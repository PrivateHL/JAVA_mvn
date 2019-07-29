package FTP;

import com.jcraft.jsch.*;

import java.io.*;
import java.util.Properties;

/**
 * @Title : Sftp工具类
 * @Document : 提供文件上传功能
 *
 * <!--sftp上传需要的jar-->
 * <dependency>
 *    <groupId>com.jcraft</groupId>
 *    <artifactId>jsch</artifactId>
 *    <version>0.1.55</version>
 * </dependency>
 */
public class SFtpUtils {

    // 初始化单例对象
    private static SFtpUtils sFtpUtils = new SFtpUtils();
    private  String host;//服务器连接ip
    private String username;//用户名
    private String password;//密码
    private int port = 22;//端口号
    private ChannelSftp sftp = null;
    private Session sshSession = null;

    /**
     * 初始化sftp的单例对象
     * @return
     */
    public static SFtpUtils getInstance()
    {
        return sFtpUtils;
    }


    /**
     *  初始化sft链接信息，必须先做这个
     * @param host 远程主机ip
     * @param port 端口号
     * @param username 账号
     * @param password 密码
     */
    public  void init(String host, int port, String username, String password)
    {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;

    }




    /**
     * 通过SFTP连接服务器
     */
    public void connect()
    {
        try
        {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     */
    public void disconnect()
    {
        if (this.sftp != null)
        {
            if (this.sftp.isConnected())
            {
                this.sftp.disconnect();

            }
        }
        if (this.sshSession != null)
        {
            if (this.sshSession.isConnected())
            {
                this.sshSession.disconnect();

            }
        }
    }

    /**
     *  sftp下载文件
     * @param remoteFielPath  远程文件路径
     * @param localFilePath 本地下载路径
     * @return
     * @throws SftpException
     * @throws FileNotFoundException
     */
    public boolean downLoadFile(String remoteFielPath,String localFilePath) throws SftpException, FileNotFoundException {
        // 检查文件是否存在
        SftpATTRS sftpATTRS = sftp.lstat(remoteFielPath);
        if(!sftpATTRS.isReg()){
            // 不是一个文件，返回false
            return false;
        }
        // 下载文件到本地
        sftp.get(remoteFielPath,localFilePath);

        return true;
    }

    /**
     * 下载文件放回文件数据
     * @param remoteFielPath
     * @return
     * @throws SftpException
     * @throws IOException
     */
    public boolean downLoadFileTwo(String remoteFielPath, String localFilePath) throws SftpException, IOException {
        // 检查文件是否存在
        SftpATTRS sftpATTRS = sftp.lstat(remoteFielPath);
        // 判断是否是一个文件
        if(sftpATTRS.isReg()){
            // 下载文件到本地
            InputStream inputStream = sftp.get(remoteFielPath);
            /**今天想写下从sftp下载文件到本地，虽然sftp提供了get(String remotePath,String LocalPath)方法，将远程文件写入到本地。
             * 但还是想属性下从远程获取InputStream对象写入到本地的方式。
             * 遇到的问题：刚开始只想这实现，就是获取byte对象写入到本地文件，先用ByteArrayInputStream怎么转都无法获取到bytes对象
             * 放入到FileOutputStream对象中。搞了老半天都没有搞定，或许有ByteArrayInputStream对象下载的方式但没有找到。
             * 正解：如下*/
            // 通过BufferedInputStream对象缓存输入流对象获取远程的输入流
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            // 创建本地文件信息
            File file = new File("F:\\456.jpg");
            // 将本地文件放入到 本地文件输出流
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // 将本地文件输出流 放入到 缓存输出流对象
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            // 声明每次获取的byte长度
            int len = 2048;
            // 初始化byte[]
            byte[] bytes = new byte[len];
            /**通过BufferedInputStream对象获取 远程文件 InputStream的bytes字节信息，并循环添加到BufferedOutputStream缓存输出流对象中，
             * 将远程bytes数据写入到本地文件中
             * 遇到的问题：这里我一直纠结于为什么这样写会实现想要的效果，是如何写入到本地的
             * 其实这不是开发中遇到的问题的事情了，是自己困于自己设定的一个纠结情绪中了。也就是俗称的牛角尖。
             * 切记，一定不可以钻牛角尖。因为开发都是有语言规则的。按照规则来就能实现效果，脱离规则即使神仙也无能为力。
             * */
            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();
            inputStream.close();
            return true;
        }
        return false;

    }
    /**
     * 上传单个文件，通过文件路径上传
     * @param remotePath：远程保存目录
     * @param remoteFileName：保存文件名
     * @param localPath：本地上传目录(以路径符号结束)
     * @param localFileName：上传的文件名
     * @return
     */
    public boolean uploadFile(String remotePath, String remoteFileName,String localPath, String localFileName)
    {
        FileInputStream in = null;
        try
        {   // 创建目录
            createDir(remotePath);
            File file = new File(localPath + localFileName);
            in = new FileInputStream(file);
            sftp.put(in, remoteFileName);
            return true;
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (SftpException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 上传文件到sftp，通过输入流上传
     * @param remotePath
     * @param remoteFileName
     * @param inputStream
     * @return
     */
    public boolean uploadFile(String remotePath, String remoteFileName,InputStream inputStream)
    {
        FileInputStream in = null;
        try
        {   // 创建目录
            createDir(remotePath);
            sftp.put(inputStream, remoteFileName);
            return true;
        }catch (SftpException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 创建目录
     * @param createpath
     * @return
     */
    public boolean createDir(String createpath)
    {
        try
        {
            if (isDirExist(createpath))
            {
                // 有时候，开发在填写路径的时候第一个位置会忘记加"/"的根路径
                // 这回引发cd操作是发生：NO Such File 异常，所以这里处理下
                if(!(createpath.substring(0,1)=="/")){
                    createpath="/"+createpath;
                }
                this.sftp.cd(createpath);
                return true;
            }
            String pathArry[] = createpath.split("/");
            StringBuffer filePath = new StringBuffer("/");
            for (String path : pathArry)
            {
                if (path.equals(""))
                {
                    continue;
                }
                filePath.append(path + "/");
                if (isDirExist(filePath.toString()))
                {
                    sftp.cd(filePath.toString());
                }
                else
                {
                    // 建立目录
                    sftp.mkdir(filePath.toString());
                    // 进入并设置为当前目录
                    sftp.cd(filePath.toString());
                }

            }
            this.sftp.cd(createpath);
            return true;
        }
        catch (SftpException e)
        {
            e.printStackTrace();
        }
        return false;
    }



    /**
     * 判断目录是否存在,linux目录必须最前方带有"/"
     * @param directory
     * @return
     */
    public boolean isDirExist(String directory)
    {
        boolean isDirExistFlag = false;
        try
        {
            // 有时候，开发在填写路径的时候第一个位置会忘记加"/"的根路径
            // 这回引发cd操作是发生：NO Such File 异常，所以这里处理下
            if(!(directory.substring(0,1)=="/")){
                directory="/"+directory;
            }
            SftpATTRS sftpATTRS = sftp.lstat(directory);
            isDirExistFlag = true;
            return sftpATTRS.isDir();
        }
        catch (Exception e)
        {
            if (e.getMessage().toLowerCase().equals("no such file"))
            {
                isDirExistFlag = false;
            }
        }
        return isDirExistFlag;
    }


    public static void main(String arg[]) throws IOException, SftpException {
        // 获取图片的InputStream对象，并将图片生成到sftp上
        SFtpUtils sFtpUtils= SFtpUtils.getInstance();
        sFtpUtils.init("127.0.0.1",22, "sftpuser", "UIOPOopi");
        sFtpUtils.connect();
        // 上传文件
        /*File file = new File("F:\\OK.jpg");
        InputStream in = new FileInputStream(file);
        boolean flag = sFtpUtils.uploadFile("/app/xwapp/Test","1111.jpg",in);*/

        // 下载文件到本地方法1
        // boolean flag = sFtpUtils.downLoadFile("/app/xwapp/Test/1111.jpg","F:\\OKbak.jpg");
        // 下载文件到本地方法2
        boolean flag = sFtpUtils.downLoadFileTwo("/app/xwapp/Test/1111.jpg","F:\\OKbak.jpg");
        if(flag){
            System.out.println("处理成功");
        }else {
            System.out.println("处理失败");
        }
        sFtpUtils.disconnect();
    }
}

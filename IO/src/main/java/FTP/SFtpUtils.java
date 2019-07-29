package FTP;

import com.jcraft.jsch.*;

import java.io.*;
import java.util.Properties;

/**
 * @Title : Sftp������
 * @Document : �ṩ�ļ��ϴ�����
 *
 * <!--sftp�ϴ���Ҫ��jar-->
 * <dependency>
 *    <groupId>com.jcraft</groupId>
 *    <artifactId>jsch</artifactId>
 *    <version>0.1.55</version>
 * </dependency>
 */
public class SFtpUtils {

    // ��ʼ����������
    private static SFtpUtils sFtpUtils = new SFtpUtils();
    private  String host;//����������ip
    private String username;//�û���
    private String password;//����
    private int port = 22;//�˿ں�
    private ChannelSftp sftp = null;
    private Session sshSession = null;

    /**
     * ��ʼ��sftp�ĵ�������
     * @return
     */
    public static SFtpUtils getInstance()
    {
        return sFtpUtils;
    }


    /**
     *  ��ʼ��sft������Ϣ�������������
     * @param host Զ������ip
     * @param port �˿ں�
     * @param username �˺�
     * @param password ����
     */
    public  void init(String host, int port, String username, String password)
    {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;

    }




    /**
     * ͨ��SFTP���ӷ�����
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
     * �ر�����
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
     *  sftp�����ļ�
     * @param remoteFielPath  Զ���ļ�·��
     * @param localFilePath ��������·��
     * @return
     * @throws SftpException
     * @throws FileNotFoundException
     */
    public boolean downLoadFile(String remoteFielPath,String localFilePath) throws SftpException, FileNotFoundException {
        // ����ļ��Ƿ����
        SftpATTRS sftpATTRS = sftp.lstat(remoteFielPath);
        if(!sftpATTRS.isReg()){
            // ����һ���ļ�������false
            return false;
        }
        // �����ļ�������
        sftp.get(remoteFielPath,localFilePath);

        return true;
    }

    /**
     * �����ļ��Ż��ļ�����
     * @param remoteFielPath
     * @return
     * @throws SftpException
     * @throws IOException
     */
    public boolean downLoadFileTwo(String remoteFielPath, String localFilePath) throws SftpException, IOException {
        // ����ļ��Ƿ����
        SftpATTRS sftpATTRS = sftp.lstat(remoteFielPath);
        // �ж��Ƿ���һ���ļ�
        if(sftpATTRS.isReg()){
            // �����ļ�������
            InputStream inputStream = sftp.get(remoteFielPath);
            /**������д�´�sftp�����ļ������أ���Ȼsftp�ṩ��get(String remotePath,String LocalPath)��������Զ���ļ�д�뵽���ء�
             * �������������´�Զ�̻�ȡInputStream����д�뵽���صķ�ʽ��
             * ���������⣺�տ�ʼֻ����ʵ�֣����ǻ�ȡbyte����д�뵽�����ļ�������ByteArrayInputStream��ôת���޷���ȡ��bytes����
             * ���뵽FileOutputStream�����С������ϰ��춼û�и㶨��������ByteArrayInputStream�������صķ�ʽ��û���ҵ���
             * ���⣺����*/
            // ͨ��BufferedInputStream���󻺴������������ȡԶ�̵�������
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            // ���������ļ���Ϣ
            File file = new File("F:\\456.jpg");
            // �������ļ����뵽 �����ļ������
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // �������ļ������ ���뵽 �������������
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            // ����ÿ�λ�ȡ��byte����
            int len = 2048;
            // ��ʼ��byte[]
            byte[] bytes = new byte[len];
            /**ͨ��BufferedInputStream�����ȡ Զ���ļ� InputStream��bytes�ֽ���Ϣ����ѭ����ӵ�BufferedOutputStream��������������У�
             * ��Զ��bytes����д�뵽�����ļ���
             * ���������⣺������һֱ������Ϊʲô����д��ʵ����Ҫ��Ч���������д�뵽���ص�
             * ��ʵ�ⲻ�ǿ���������������������ˣ����Լ������Լ��趨��һ�������������ˡ�Ҳ�����׳Ƶ�ţ�Ǽ⡣
             * �мǣ�һ����������ţ�Ǽ⡣��Ϊ�������������Թ���ġ����չ���������ʵ��Ч�����������ʹ����Ҳ����Ϊ����
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
     * �ϴ������ļ���ͨ���ļ�·���ϴ�
     * @param remotePath��Զ�̱���Ŀ¼
     * @param remoteFileName�������ļ���
     * @param localPath�������ϴ�Ŀ¼(��·�����Ž���)
     * @param localFileName���ϴ����ļ���
     * @return
     */
    public boolean uploadFile(String remotePath, String remoteFileName,String localPath, String localFileName)
    {
        FileInputStream in = null;
        try
        {   // ����Ŀ¼
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
     * �ϴ��ļ���sftp��ͨ���������ϴ�
     * @param remotePath
     * @param remoteFileName
     * @param inputStream
     * @return
     */
    public boolean uploadFile(String remotePath, String remoteFileName,InputStream inputStream)
    {
        FileInputStream in = null;
        try
        {   // ����Ŀ¼
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
     * ����Ŀ¼
     * @param createpath
     * @return
     */
    public boolean createDir(String createpath)
    {
        try
        {
            if (isDirExist(createpath))
            {
                // ��ʱ�򣬿�������д·����ʱ���һ��λ�û����Ǽ�"/"�ĸ�·��
                // �������cd�����Ƿ�����NO Such File �쳣���������ﴦ����
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
                    // ����Ŀ¼
                    sftp.mkdir(filePath.toString());
                    // ���벢����Ϊ��ǰĿ¼
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
     * �ж�Ŀ¼�Ƿ����,linuxĿ¼������ǰ������"/"
     * @param directory
     * @return
     */
    public boolean isDirExist(String directory)
    {
        boolean isDirExistFlag = false;
        try
        {
            // ��ʱ�򣬿�������д·����ʱ���һ��λ�û����Ǽ�"/"�ĸ�·��
            // �������cd�����Ƿ�����NO Such File �쳣���������ﴦ����
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
        // ��ȡͼƬ��InputStream���󣬲���ͼƬ���ɵ�sftp��
        SFtpUtils sFtpUtils= SFtpUtils.getInstance();
        sFtpUtils.init("127.0.0.1",22, "sftpuser", "UIOPOopi");
        sFtpUtils.connect();
        // �ϴ��ļ�
        /*File file = new File("F:\\OK.jpg");
        InputStream in = new FileInputStream(file);
        boolean flag = sFtpUtils.uploadFile("/app/xwapp/Test","1111.jpg",in);*/

        // �����ļ������ط���1
        // boolean flag = sFtpUtils.downLoadFile("/app/xwapp/Test/1111.jpg","F:\\OKbak.jpg");
        // �����ļ������ط���2
        boolean flag = sFtpUtils.downLoadFileTwo("/app/xwapp/Test/1111.jpg","F:\\OKbak.jpg");
        if(flag){
            System.out.println("����ɹ�");
        }else {
            System.out.println("����ʧ��");
        }
        sFtpUtils.disconnect();
    }
}

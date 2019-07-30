package cmd;

import Basic.FileUtils;
import Basic.ValueWidget;
import System.SystemUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdUtils {

    public static final String MAVEN_INSTALL_JAR_CMD=
            "mvn install:install-file  -Dfile=%s  -DgroupId=%s  -DartifactId=%s -Dversion=%s -Dpackaging=%s";
    public static final String mCurrentPath = System.getProperty("user.dir");
    public static final String mCurrentDrive = mCurrentPath.substring(0, 2);

    public static String mavenIntall(String filepath,String group,String artifact,String version,String packaging){

        String cmd = String.format(MAVEN_INSTALL_JAR_CMD,filepath,group,artifact,version,packaging);
        return getResult4Cmd(cmd);
    }

    public static String getResult4Cmd(String cmd){
        String code = "cmd /c cd  " + mCurrentPath + " && " + mCurrentDrive + " && " + cmd ;
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(code);
            br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getResult4cmd(String cmd){
        return getResult4cmd(cmd, null);
    }
    public static String getResult4cmd(String cmd,String charset){
        if(ValueWidget.isNullOrEmpty(charset)){
            charset=SystemUtil.CURR_ENCODING;
        }
//        BufferedReader reader =CmdUtils.cmdCmdreReader(cmd,charset);
//        String content= FileUtils.getFullContent(reader);
        String content = CmdUtils.cmdOutput(cmd,charset);
        return content;
    }

    public static BufferedReader cmdCmdreReader(String command,String charset)
    {
        if(charset==null || charset.equals("")){
            charset=SystemUtil.CURR_ENCODING;
        }
        Process p = null;
        BufferedReader reader = null;
        try
        {
            String command2= SystemUtil.CMD_SHORT + command;
            p = Runtime.getRuntime().exec(command2);
            System.out.println(command2);
            reader = new BufferedReader(new InputStreamReader(p.getInputStream(),charset));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return reader;
    }
    /**
    * @Description: 得到cmd 的输出，没有标准的正常输出时，读取错误输出。
    * @param:   [command, charset]
    * @return:  java.lang.String
    * @Author:  HeLing
    * @Date: 2019/7/30 15:06
    */
    public static String cmdOutput(String command , String charset){
        if(charset==null || charset.equals("")){
            charset=SystemUtil.CURR_ENCODING;
        }
        Process p = null;
        BufferedReader reader = null;
        BufferedReader reader_error = null;
        try
        {
            String command2= SystemUtil.CMD_SHORT + command;
            p = Runtime.getRuntime().exec(command2);
            System.out.println(command2);
            reader = new BufferedReader(new InputStreamReader(p.getInputStream(),charset));
            reader_error = new BufferedReader(new InputStreamReader(p.getErrorStream(),charset));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String content = FileUtils.getFullContent(reader);
        content += "\n" + FileUtils.getFullContent(reader_error);
        return content;
    }
}

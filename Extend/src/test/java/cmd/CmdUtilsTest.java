package cmd;


import org.junit.Test;

public class CmdUtilsTest {
    @Test
    public void getResult4cmd() {
        //String cmd = "mvn install:install-file -Dfile=E:\\workspace\\IDEA201803\\JAVA\\lib\\juit-4.12.jar -DgroupId='junit' -DartifactId=junit -Dversion='4.12' -Dpackaging=jar";
        String cmd = "mvn -version";
        String res = CmdUtils.getResult4cmd(cmd);
        System.out.println(res);
    }
}

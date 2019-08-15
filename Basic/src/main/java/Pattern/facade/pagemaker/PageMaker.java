package Pattern.facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description 外观模式的外观 整合HtmlWriter和Database的接口，对外提供一个简单的高层接口makeWlecomePage
 * @Author Heling
 * @Date 2019/8/15 10:58
 **/
public class PageMaker {
    private PageMaker(){}

    public static void makeWelcomePage(String mailaddr,String filename){
        try{
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.setTitle("welcome to " + username + "'s page!");
            writer.paragragh("欢迎来到 " + username +"的主页。");
            writer.paragragh("等你的邮件哦。");
            writer.mailto(mailaddr,username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + "(" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Pattern.facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description ���ģʽ����� ����HtmlWriter��Database�Ľӿڣ������ṩһ���򵥵ĸ߲�ӿ�makeWlecomePage
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
            writer.paragragh("��ӭ���� " + username +"����ҳ��");
            writer.paragragh("������ʼ�Ŷ��");
            writer.mailto(mailaddr,username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + "(" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

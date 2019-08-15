package Pattern.facade.pagemaker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description 內部功能模塊 提供屬性
 * @Author Heling
 * @Date 2019/8/15 11:15
 **/
public class Database {
    public Database() {
    }
    public static Properties getProperties(String dbName){
        String filename = dbName + ".txt";
        Properties prop = new Properties();
        try{
            prop.load(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            System.out.println("warning : " + filename + " is bot found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}

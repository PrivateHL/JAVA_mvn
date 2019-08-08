package Pattern.bridge;

import java.io.*;
/**
* @Description: 桥接模式练习题三 拓展文件打印功能
* @Author:  HeLing
* @Date: 2019/8/8 10:29
*/ 
public class FileDisplayImpl extends DisplayImpl {
    File file ;
    BufferedReader reader;

    public FileDisplayImpl(File file) {
        this.file = file;
    }

    public FileDisplayImpl(String filePath) {
        this.file = new File(filePath);
    }


    public void rawOpen() {
        try {
            reader = new BufferedReader(new FileReader(file));
            System.out.println("######START#######");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void rawPrint() {
        String line;
        try {
            while ( (line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void rawClose() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("######END#######");
    }
}

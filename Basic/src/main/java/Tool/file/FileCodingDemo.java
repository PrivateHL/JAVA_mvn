package Tool.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Description txt�ļ��ı����ʽ��������
 * @Author Heling
 * @Date 2019/11/22 10:12
 **/
public class FileCodingDemo {

    private  OutputStreamWriter writer;
    public static void main(String[] args) {
        String path = "E:\\coding.txt";
        File file = new File(path);
        try {
            file.createNewFile();
            FileCodingDemo demo = new FileCodingDemo();
            demo.writer = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
            for (int i = 0; i < 10; i++) {
                demo.writeAndFlush("fsdafdsˮ��ѿ�ʦ������afdf!" + "\r\n");
                demo.writeAndFlush("fsdafdsˮ��ѿ�ʦ������afdf��" + "\r\n");
                Thread.sleep(1000);
            }
            demo.writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeAndFlush(String msg){
        try {
            writer.write(msg);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

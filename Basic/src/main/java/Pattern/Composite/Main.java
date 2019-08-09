package Pattern.Composite;

/**
 * @Description ����ģʽ��ʹ���߽�ɫ
 * @Author Heling
 * @Date 2019/8/9 18:39
 **/
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("makeing root entrties.....");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tempdir = new Directory("temp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tempdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi",1000));
            bindir.add(new File("latex", 2000));
            rootdir.printList("");
        }catch (FileThreatmentException e){
            e.printStackTrace();
        }
    }
}

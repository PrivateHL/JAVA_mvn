package Pattern.Visitor;

/**
 * @Description 观察者模式测试
 * @Author Heling
 * @Date 2019/8/13 19:23
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
            rootdir.accept(new ListVisitor());
        }catch (FileThreatmentException e){
            e.printStackTrace();
        }
    }
}

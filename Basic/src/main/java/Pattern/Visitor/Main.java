package Pattern.Visitor;

import java.util.Iterator;

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
            Directory bindir = new Directory("binss");
            Directory tempdir = new Directory("temp");
            Directory usrdir = new Directory("usrs");
            rootdir.add(bindir);
            rootdir.add(tempdir);
            rootdir.add(usrdir);
            rootdir.add(new File("name.name",50));
            bindir.add(new File("vi.t",1000));
            bindir.add(new File("latex", 2000));
            rootdir.accept(new ListVisitor());

            FileFindVisitor ffv = new FileFindVisitor("name");
            rootdir.accept(ffv);
            System.out.println("found files are:");
            Iterator it  = ffv.getFoundFiles();
            while(it.hasNext()){
                File file = (File) it.next();
                System.out.println(file.toString());
            }

            SizeVisitor sv = new SizeVisitor();
            rootdir.accept(sv);
            System.out.println(rootdir + " total size : " + sv.getSize());

            Directory root1 = new Directory("root1");
            Directory root2 = new Directory("root2");
            root1.add(new File("diary.html",10));
            root2.add(new File("diary.html",1000));
            root1.add(new File("index.html",20));
            root2.add(new File("index.html",2000));
            ElementArrayList list = new ElementArrayList();
            list.add(root1);
            list.add(root2);
            list.add(new File("etc.html",1234));

            list.accept(new ListVisitor());

            //String 是final类 视乎违反了开闭原则，有什么理由
            //核心类，JAVA操作系统语言，内部方法依赖于操作系统本地方法，安全性；不希望被随意继承更改
            //继承String重写了方法，可能攻击操作系统
        }catch (FileThreatmentException e){
            e.printStackTrace();
        }
    }
}

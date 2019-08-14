package Pattern.Visitor;

import java.util.Iterator;

/**
 * @Description �۲���ģʽ����
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

            //String ��final�� �Ӻ�Υ���˿���ԭ����ʲô����
            //�����࣬JAVA����ϵͳ���ԣ��ڲ����������ڲ���ϵͳ���ط�������ȫ�ԣ���ϣ��������̳и���
            //�̳�String��д�˷��������ܹ�������ϵͳ
        }catch (FileThreatmentException e){
            e.printStackTrace();
        }
    }
}

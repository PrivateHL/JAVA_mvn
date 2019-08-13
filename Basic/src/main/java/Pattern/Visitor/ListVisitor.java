package Pattern.Visitor;

import java.util.Iterator;

/**
 * @Description ����ķ����� ��Բ�ͬ�Ķ��� ��ͬ�ķ��ʴ���
 * @Author Heling
 * @Date 2019/8/13 19:16
 **/
public class ListVisitor extends Visitor {
    private String currentdir = "";
    public void visit(File file) {
        System.out.println(currentdir + "/" + file);
    }

    public void visit(Directory directory) {

        System.out.println(currentdir + "/" + directory.getName());
        String savedir = currentdir + "/" + directory.getName();
        Iterator it = directory.iterator();
        while(it.hasNext()){
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}

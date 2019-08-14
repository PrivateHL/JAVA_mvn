package Pattern.Visitor;

import java.util.Iterator;

/**
 * @Description �۲���ģʽ��ϰ�� ʹ�ù۲���ģʽ�ṩ�����ļ������ļ���С�Ĺ���
 * @Author Heling
 * @Date 2019/8/14 10:11
 **/
public class SizeVisitor extends Visitor {
    private int size = 0;
    public void visit(File file) {
        size += file.getSize();
    }

    public void visit(Directory directory) {

        Iterator it = directory.iterator();
        while(it.hasNext()){
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
    }

    public int getSize(){
        return size;
    }
}

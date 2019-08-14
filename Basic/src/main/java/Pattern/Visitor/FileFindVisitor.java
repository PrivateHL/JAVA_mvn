package Pattern.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description �۲���ģʽ ��ϰ1 �ҳ��ļ������ض��������ļ�
 * @Author Heling
 * @Date 2019/8/14 9:35
 **/
public class FileFindVisitor extends  Visitor {
    String str;
    ArrayList altFoundFiles = new ArrayList();

    public FileFindVisitor(String str) {
        this.str = str;
    }

    public void visit(File file) {

        if(file.getName().endsWith(str)){
            altFoundFiles.add(file);
        }
    }

    public void visit(Directory directory) {

        Iterator it = directory.iterator();
        while(it.hasNext()){
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
    }

    public Iterator getFoundFiles(){
        Iterator it = altFoundFiles.iterator();
        return it;
    }
}

package Pattern.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description 观察者模式 练习1 找出文件夹中特定的所有文件
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

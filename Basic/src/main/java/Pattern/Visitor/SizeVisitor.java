package Pattern.Visitor;

import java.util.Iterator;

/**
 * @Description 观察者模式练习二 使用观察者模式提供计算文件夹内文件大小的功能
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

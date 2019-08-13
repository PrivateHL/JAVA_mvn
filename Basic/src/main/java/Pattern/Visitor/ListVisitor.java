package Pattern.Visitor;

import java.util.Iterator;

/**
 * @Description 具体的访问者 针对不同的对象 不同的访问处理
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

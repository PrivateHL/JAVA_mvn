package Pattern.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description 观察者模式练习题3 编写一个具有element接口的ElementArrayList类，保存File和Director,接受ListVisitor访问
 * @Author Heling
 * @Date 2019/8/14 10:18
 **/
public class ElementArrayList extends ArrayList implements Element {

    public void accept(Visitor v) {
        Iterator it = this.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            if(obj instanceof Entry){
                Entry entry = (Entry) obj;
                entry.accept(v);
            }
        }
    }
}

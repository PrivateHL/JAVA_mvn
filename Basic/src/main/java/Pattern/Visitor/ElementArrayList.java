package Pattern.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description �۲���ģʽ��ϰ��3 ��дһ������element�ӿڵ�ElementArrayList�࣬����File��Director,����ListVisitor����
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

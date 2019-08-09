package Pattern.Composite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description ����ģʽ�е��ļ��ж�����һ����Ŀ��������һ��list������Ŀ��������������ͬʱ��Ҳ���Ա��������ݴ���������
 * @Author Heling
 * @Date 2019/8/9 18:26
 **/
public class Directory extends Entry {
    private  String name;
    private ArrayList directory = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return null;
    }

    public int getSize() {
        int size = 0;
        Iterator it = directory.iterator();
        while (it.hasNext()){
            Entry entry = (Entry) it.next();
            size += entry.getSize();
        }
        return size;
    }

    public void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator it = directory.iterator();
        while(it.hasNext()){
            Entry entry = (Entry) it.next();
            entry.printList(prefix + "/" + name);
        }
    }

    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}

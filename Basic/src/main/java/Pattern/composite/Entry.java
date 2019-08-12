package Pattern.composite;

/**
 * @Description ����ģʽ�е���Ŀ�������ļ����ļ��еĳ����࣬ͳһ��Ŀ���ԣ������ܱ�ʵ������
 * ��Ϊ�����ò����ļ�Ҳ�����ļ��е���Ŀ����
 * @Author Heling
 * @Date 2019/8/9 18:16
 **/
public abstract class Entry {
    protected Entry parent;
    public abstract String getName();
    public abstract int getSize();
    public abstract void printList(String prefix);
    public abstract Entry add(Entry entry);

    public void printlist(){
        printList("");
    }
    public String getFullName(){
        StringBuffer fullname = new StringBuffer();
        Entry entry = this;
        do{
            fullname .insert(0,"/" + entry.getName());
            entry = entry.parent;
        }while(entry != null );
        return fullname.toString();
    }
    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}

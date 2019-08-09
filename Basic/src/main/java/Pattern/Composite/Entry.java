package Pattern.Composite;

/**
 * @Description ����ģʽ�е���Ŀ�������ļ����ļ��еĳ����࣬ͳһ��Ŀ���ԣ������ܱ�ʵ������
 * ��Ϊ�����ò����ļ�Ҳ�����ļ��е���Ŀ����
 * @Author Heling
 * @Date 2019/8/9 18:16
 **/
public abstract class Entry {
    public abstract String getName();
    public abstract int getSize();
    public abstract void printList(String prefix);
    public abstract Entry add(Entry entry);

    public void printlist(){
        printList("");
    }
    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}

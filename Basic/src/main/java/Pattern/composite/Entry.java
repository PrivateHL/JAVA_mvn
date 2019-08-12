package Pattern.composite;

/**
 * @Description 复合模式中的条目对象，是文件和文件夹的抽象父类，统一条目特性，但不能被实例化。
 * 因为不能用不是文件也不是文件夹的条目存在
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

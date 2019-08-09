package Pattern.Composite;

/**
 * @Description 复合模式中的条目对象，是文件和文件夹的抽象父类，统一条目特性，但不能被实例化。
 * 因为不能用不是文件也不是文件夹的条目存在
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

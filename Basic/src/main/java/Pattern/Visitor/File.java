package Pattern.Visitor;

/**
 * @Description 复合模式中的文件对象，父类是entry
 * @Author Heling
 * @Date 2019/8/9 18:23
 **/
public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }

    public Entry add(Entry entry) {
        throw new FileThreatmentException("File 类不允许添加下级条目");
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

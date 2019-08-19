package Pattern.composite;

/**
 * @Description ����ģʽ�е��ļ����󣬸�����entry
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
        return 0;
    }

    public void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }

    public Entry add(Entry entry) {
        throw new FileThreatmentException("File �಻���������¼���Ŀ");
    }

}
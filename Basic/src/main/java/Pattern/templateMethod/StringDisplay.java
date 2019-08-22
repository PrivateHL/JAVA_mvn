package Pattern.templateMethod;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/22 11:25
 **/
public class StringDisplay extends AbstractDisplay {
    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        width = string.getBytes().length;
    }

    public void open() {
        printLine();
    }

    public void print() {
        System.out.println(string);
    }

    public void close() {
        printLine();
    }

    private void printLine() {
        for (int i = 0; i < width; i++) {
            System.out.println("+");
        }
    }
}

package Pattern.templateMethod;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/22 11:24
 **/
public class CharDisplay extends AbstractDisplay {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    public void open() {
        System.out.println("<<");
    }

    public void print() {
        System.out.println(ch);
    }

    public void close() {
        System.out.println(">>");
    }
}

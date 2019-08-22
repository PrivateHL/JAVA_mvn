package Pattern.Adapter;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/22 11:08
 **/
public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("hello");
        p.printWeak();
        p.printStrong();
    }
}

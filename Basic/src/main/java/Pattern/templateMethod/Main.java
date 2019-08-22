package Pattern.templateMethod;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/22 11:27
 **/
public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Heloo");
        d1.dispaly();
        d2.dispaly();
    }
}

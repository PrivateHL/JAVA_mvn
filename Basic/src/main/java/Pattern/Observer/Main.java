package Pattern.Observer;

/**
 * @Description ���ɹ۲��ߡ��۲����ʵ����ע��۲���
 * @Author Heling
 * @Date 2019/8/16 11:33
 **/
public class Main {
    public static void main(String[] args) {

        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}

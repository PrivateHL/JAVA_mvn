package Pattern.Observer;

/**
 * @Description 具体观察者
 * @Author Heling
 * @Date 2019/8/16 11:38
 **/
public class DigitObserver implements Observer {
    public void update(NumberGenerator generator) {

        System.out.println("DigitObserver:" + generator.getNumber());
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

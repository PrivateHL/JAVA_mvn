package Pattern.Observer;

/**
 * @Description π€≤Ï’ﬂ1
 * @Author Heling
 * @Date 2019/8/16 12:29
 **/
public class GraphObserver implements Observer {
    public void update(NumberGenerator generator) {
        System.out.println("GraphObserver:");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.println("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

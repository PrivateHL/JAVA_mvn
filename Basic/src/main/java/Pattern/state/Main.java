package Pattern.state;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/19 19:13
 **/
public class Main {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("Sate Sample");
        while(true){
            for (int i = 0; i <24 ; i++) {
                frame.setClock(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

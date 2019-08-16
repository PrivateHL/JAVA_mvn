package Pattern.Observer;

import java.util.Random;

/**
 * @Description 具体的被观察对象
 * @Author Heling
 * @Date 2019/8/16 11:44
 **/
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();
    private int number;
    public int getNumber() {
        return number;
    }

    public void execute() {
        for (int i = 0; i <20 ; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}

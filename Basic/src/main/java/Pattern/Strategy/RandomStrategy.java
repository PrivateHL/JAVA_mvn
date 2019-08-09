package Pattern.Strategy;

import java.util.Random;

/**
 * @Description 猜拳策略模式中 随机策略类
 * @Author Heling
 * @Date 2019/8/9 16:44
 **/
public class RandomStrategy implements Strategy {
    private Random random ;

    public RandomStrategy(int seed) {
        random = new Random(seed);
    }

    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }

    public void study(boolean win) {
        //do nothing
    }
}

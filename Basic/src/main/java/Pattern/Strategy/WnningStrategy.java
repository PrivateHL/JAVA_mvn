package Pattern.Strategy;

import java.util.Random;

/**
* @Description:
* @Author:  HeLing
* @Date: 2019/8/9 10:43
*/
public class WnningStrategy implements Strategy {

    private Random random;
    private boolean won = false;
    private Hand prevHand;
    public WnningStrategy (int seed){
        random = new Random(seed);
    }
    public Hand nextHand() {
        if( !won ){
            prevHand = Hand.getHand(random.nextInt(3));
        }
         return prevHand;
    }
    public void study(boolean win) {
        won = win;
    }
}

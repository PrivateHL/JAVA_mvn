package Pattern.bridge;

import java.util.Random;
/**
* @Description: 桥接模式练习题1
* @Author:  HeLing
* @Date: 2019/8/8 10:08
*/ 
public class RandomDispaly extends CountDisplay {
    public RandomDispaly(DisplayImpl displayImpl) {
        super(displayImpl);
    }
    /**
    * @Description: 随机打印0-times次
    * @param:   [times]
    * @return:  void
    * @Author:  HeLing
    * @Date: 2019/8/8 9:55
    */
    public void randomDisplay(int times){
        Random random = new Random();
        countDisplay(random.nextInt(times + 1));
        //countDisplay((int)Math.random()*times);
    }

}

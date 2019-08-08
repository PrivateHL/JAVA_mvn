package Pattern.bridge;

/**
* @Description: �Ž�ģʽ ���ܲ㼶�ṹ ���Ƶĳ���
* @Author:  HeLing
* @Date: 2019/8/7 13:13
*/ 
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl displayImpl) {
        super(displayImpl);
    }
    public final void countDisplay(int times){
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
    public final void reaptDispaly(int times){
        for (int i = 0; i < times; i++) {
            countDisplay(i);
        }
    }
}

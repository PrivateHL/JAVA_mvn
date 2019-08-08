package Pattern.Strategy;

public class Hand {
    /** 表示石头的值 **/
    public static final int HANDVALUE_GUU = 0 ;
    /** 表示剪刀的值 **/
    public static final int HANDVALUE_CHO = 1 ;
    /** 表示布的值 **/
    public static final int HANDVALUE_PAA = 2 ;
    /** 表示猜拳中的3种手势的实例 **/
    public static final Hand[] hands = {
            new Hand(HANDVALUE_GUU);
            new Hand(HANDVALUE_CHO);
            new Hand(HANDVALUE_PAA);
    } ;
    /** 表示猜拳中手势对应的字符串 **/
    private static final String[] name = {  "石头","剪刀","布",  };
    private int handvalue;
    private Hand(int handvalue){
        this.handvalue = handvalue;
        }

}

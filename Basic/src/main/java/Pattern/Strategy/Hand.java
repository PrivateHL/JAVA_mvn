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
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA),
    };
    /** 表示猜拳中手势对应的字符串 **/
    private static final String[] name = {  "石头","剪刀","布",  };
    /** 表示猜拳中出的手势的值 **/
    private int handvalue;

    /** 私有构造器，单例模式，只有三个出拳的手对象 **/
    private Hand(int handvalue){
        this.handvalue = handvalue;
    }
    
    /** 根据对应的值获取对应的手的实例 **/
    public static Hand getHand(int handvalue){
        return hands[handvalue];
    }
    /** compare方法比较输赢，1-表示赢，0-表示平，-1表示输 **/
    public int fight(Hand h){
        if(this == h){
            return 0;
        }else if( (this.handvalue + 1) % 3 == h.handvalue){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Hand{" +
                "handname=" + name[handvalue] +
                '}';
    }
}

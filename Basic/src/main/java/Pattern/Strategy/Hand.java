package Pattern.Strategy;

public class Hand {
    /** ��ʾʯͷ��ֵ **/
    public static final int HANDVALUE_GUU = 0 ;
    /** ��ʾ������ֵ **/
    public static final int HANDVALUE_CHO = 1 ;
    /** ��ʾ����ֵ **/
    public static final int HANDVALUE_PAA = 2 ;
    /** ��ʾ��ȭ�е�3�����Ƶ�ʵ�� **/
    public static final Hand[] hands = {
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA),
    };
    /** ��ʾ��ȭ�����ƶ�Ӧ���ַ��� **/
    private static final String[] name = {  "ʯͷ","����","��",  };
    /** ��ʾ��ȭ�г������Ƶ�ֵ **/
    private int handvalue;

    /** ˽�й�����������ģʽ��ֻ��������ȭ���ֶ��� **/
    private Hand(int handvalue){
        this.handvalue = handvalue;
    }
    
    /** ���ݶ�Ӧ��ֵ��ȡ��Ӧ���ֵ�ʵ�� **/
    public static Hand getHand(int handvalue){
        return hands[handvalue];
    }
    /** compare�����Ƚ���Ӯ��1-��ʾӮ��0-��ʾƽ��-1��ʾ�� **/
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

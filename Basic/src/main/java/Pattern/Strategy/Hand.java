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
            new Hand(HANDVALUE_GUU);
            new Hand(HANDVALUE_CHO);
            new Hand(HANDVALUE_PAA);
    } ;
    /** ��ʾ��ȭ�����ƶ�Ӧ���ַ��� **/
    private static final String[] name = {  "ʯͷ","����","��",  };
    private int handvalue;
    private Hand(int handvalue){
        this.handvalue = handvalue;
        }

}

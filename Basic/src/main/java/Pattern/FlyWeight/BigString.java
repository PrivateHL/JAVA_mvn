package Pattern.FlyWeight;

/**
 * @Description 共享实例使用者
 * @Author Heling
 * @Date 2019/8/20 10:27
 **/
public class BigString {
    private BigChar[] bigchars;
    public BigString(String string){
        bigchars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i <bigchars.length ; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }
    public  void print(){
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print();
        }
    }
}

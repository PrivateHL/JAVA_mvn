package Pattern.FlyWeight;

import java.util.HashMap;

/**
 * @Description ����ʵ���Ĺ���������������Դ�����
 * @Author Heling
 * @Date 2019/8/20 10:26
 **/
public class BigCharFactory {
    private HashMap pool = new HashMap();
    private static BigCharFactory singleton = new BigCharFactory();

    private BigCharFactory(){}

    public static BigCharFactory getInstance(){
        return singleton;
    }
    public synchronized BigChar getBigChar(char name){
        BigChar bc = (BigChar) pool.get("" + name);
        if(bc == null){
            bc = new BigChar(name);
            pool.put("" + name, bc);
        }
        return bc;
    }
}

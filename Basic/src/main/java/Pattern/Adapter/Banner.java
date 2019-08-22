package Pattern.Adapter;

/**
 * @Description �ṩ����Ķ����ṩ���ʽӿڣ�ԭʼ�ķ���ӿڣ�������ʹ���ߵ�����
 * @Author Heling
 * @Date 2019/8/22 10:49
 **/
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }
    public void showWithParen(){
        System.out.println("(" + string + ")");
    }
    public void showWithAster(){
        System.out.println("*" + string + "*");
    }
}

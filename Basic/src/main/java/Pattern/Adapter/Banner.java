package Pattern.Adapter;

/**
 * @Description 提供服务的对象，提供访问接口（原始的服务接口，不满足使用者的需求）
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

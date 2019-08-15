package Pattern.ChainOfResponsibility;

/**
 * @Description 请求处理的问题对象
 * @Author Heling
 * @Date 2019/8/15 10:37
 **/
public class Trouble {
    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public  int getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return "Trouble{" +
                "number=" + number +
                '}';
    }
}

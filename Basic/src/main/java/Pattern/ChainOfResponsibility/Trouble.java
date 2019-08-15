package Pattern.ChainOfResponsibility;

/**
 * @Description ��������������
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

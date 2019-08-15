package Pattern.ChainOfResponsibility;

/**
 * @Description ����ְ��λ4 ֻ���ָ����ŵ�����
 * @Author Heling
 * @Date 2019/8/15 10:51
 **/
public class SpecialSupport extends Support {
    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() == number){
            return true;
        }else {
            return false;
        }
    }
}

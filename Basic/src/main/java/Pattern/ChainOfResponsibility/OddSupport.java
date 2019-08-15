package Pattern.ChainOfResponsibility;

/**
 * @Description ����ְ��λ3 ���������ŵ�����
 * @Author Heling
 * @Date 2019/8/15 10:49
 **/
public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() % 2 == 1){
            return true;
        }else {
            return false;
        }
    }
}

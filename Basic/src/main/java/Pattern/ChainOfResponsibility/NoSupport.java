package Pattern.ChainOfResponsibility;

/**
 * @Description ����ְ��λ1 �������κ�trouble
 * @Author Heling
 * @Date 2019/8/15 10:46
 **/
public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }

    protected boolean resolve(Trouble trouble) {
        return false;
    }
}

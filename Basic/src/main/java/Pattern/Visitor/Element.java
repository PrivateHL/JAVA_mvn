package Pattern.Visitor;

/**
 * @Description ���ܷ��ʵĳ�����Ԫ�� ����������õ��Ľӿ�
 * @Author Heling
 * @Date 2019/8/13 19:01
 **/
public interface Element {
    public abstract void accept(Visitor v);
}

package Pattern.decorator;

/**
 * @Description �����װ���࣬Ϊ�˼̳�������������һ���ԣ�����ʵ�ֲ��Ƕ�ס�
 * @Author Heling
 * @Date 2019/8/12 11:34
 **/
public abstract class Border extends Display {
    protected Display display;//��װ����

    public Border(Display display) {
        this.display = display;
    }
}

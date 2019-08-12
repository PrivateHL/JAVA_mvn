package Pattern.decorator;

/**
 * @Description װ��ģʽ �������������װ��ģʽ��Ҫ�õ����ص�.��ʾ���ݵ��ص���������
 * @Author Heling
 * @Date 2019/8/12 11:14
 **/
public abstract class Display {
    public abstract  int getColumns();
    public abstract int getRows();
    public abstract  String getRowText(int row);
    public final void show(){
        for (int i = 0; i <getRows() ; i++) {
            System.out.println(getRowText(i));
        }
    }
}

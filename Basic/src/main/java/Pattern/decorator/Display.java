package Pattern.decorator;

/**
 * @Description 装饰模式 抽象组件，抽象装饰模式需要用到的特点.显示内容的特点行列数。
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

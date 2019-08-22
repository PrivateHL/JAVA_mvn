package Pattern.templateMethod;

/**
 * @Description 抽象的模板类，提炼出统一的方法
 * @Author Heling
 * @Date 2019/8/22 11:22
 **/
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    public final void dispaly(){
        open();
        for (int i = 0; i < 5 ; i++) {
            print();
        }
        close();
    }
}

package Pattern.Visitor;

/**
 * @Description 接受访问的抽象父类元素 定义访问者用到的接口
 * @Author Heling
 * @Date 2019/8/13 19:01
 **/
public interface Element {
    public abstract void accept(Visitor v);
}

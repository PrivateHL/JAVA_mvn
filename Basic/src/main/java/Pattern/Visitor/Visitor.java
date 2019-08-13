package Pattern.Visitor;

/**
 * @Description 观察者模式 抽象的观察者
 * @Author Heling
 * @Date 2019/8/13 18:58
 **/
public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}

package Pattern.Visitor;

/**
 * @Description �۲���ģʽ ����Ĺ۲���
 * @Author Heling
 * @Date 2019/8/13 18:58
 **/
public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}

package Pattern.decorator;

/**
 * @Description 抽象的装饰类，为了继承组件，和组件有一致性，可以实现层层嵌套。
 * @Author Heling
 * @Date 2019/8/12 11:34
 **/
public abstract class Border extends Display {
    protected Display display;//被装饰物

    public Border(Display display) {
        this.display = display;
    }
}

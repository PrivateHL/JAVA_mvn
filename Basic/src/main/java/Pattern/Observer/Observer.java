package Pattern.Observer;

/**
 * @Description 观察者抽象接口，声明通知入口
 * @Author Heling
 * @Date 2019/8/16 11:35
 **/
public interface Observer {
    public abstract void update(NumberGenerator generator);
}

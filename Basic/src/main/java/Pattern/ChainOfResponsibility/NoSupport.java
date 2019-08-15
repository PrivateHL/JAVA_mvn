package Pattern.ChainOfResponsibility;

/**
 * @Description 处理职责单位1 不处理任何trouble
 * @Author Heling
 * @Date 2019/8/15 10:46
 **/
public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }

    protected boolean resolve(Trouble trouble) {
        return false;
    }
}

package Pattern.ChainOfResponsibility;

/**
 * @Description 处理职责单位2 解决编号小于limit值的问题
 * @Author Heling
 * @Date 2019/8/15 10:47
 **/
public class LimitSupport extends Support {

    private  int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit ){
            return true;
        }else {
            return false;
        }
    }
}

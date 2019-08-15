package Pattern.ChainOfResponsibility;

/**
 * @Description 处理职责单位3 解决奇数编号的问题
 * @Author Heling
 * @Date 2019/8/15 10:49
 **/
public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() % 2 == 1){
            return true;
        }else {
            return false;
        }
    }
}

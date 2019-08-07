package Pattern.bridge;
/**
* @Description: 桥接模式 类层级结构 实现者
* @Author:  HeLing
* @Date: 2019/8/7 13:14
*/ 
public abstract class DisplayImpl {

    public abstract void rawOpen();
    public abstract void rawPrint();
    public abstract void rawClose();
}

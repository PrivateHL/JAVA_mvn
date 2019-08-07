package Pattern.bridge;

/**
* @Description: 功能层级结构 桥接模式：抽象化
* @Author:  HeLing
* @Date: 2019/8/7 13:13
*/ 
public class Display {
    private DisplayImpl displayImpl;
    public void open(){
        displayImpl.rawOpen();
    }
    public void print(){
        displayImpl.rawPrint();
    }
    public void close(){
        displayImpl.rawClose();
    }

    public Display(DisplayImpl displayImpl) {
        this.displayImpl = displayImpl;
    }

    public final void display(){
        open();
        print();
        close();
    }

}

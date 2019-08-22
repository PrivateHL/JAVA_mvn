package Pattern.Adapter;

/**
 * @Description 适配器，继承服务提供者，实现使用者的接口
 * @Author Heling
 * @Date 2019/8/22 11:06
 **/
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    public void printWeak() {
        showWithParen();
    }

    public void printStrong() {
        showWithAster();
    }
}

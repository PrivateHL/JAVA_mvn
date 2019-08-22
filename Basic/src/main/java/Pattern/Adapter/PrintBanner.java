package Pattern.Adapter;

/**
 * @Description ���������̳з����ṩ�ߣ�ʵ��ʹ���ߵĽӿ�
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

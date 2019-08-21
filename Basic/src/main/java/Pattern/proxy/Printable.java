package Pattern.proxy;

/**
 * @Description ����ͱ����һ���Խӿ�
 * @Author Heling
 * @Date 2019/8/21 12:47
 **/
public interface Printable {
    public abstract void setPrinterName(String name);
    public abstract String getPrinterName();
    public abstract void print(String string);

}

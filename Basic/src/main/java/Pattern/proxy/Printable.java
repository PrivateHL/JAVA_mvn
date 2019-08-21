package Pattern.proxy;

/**
 * @Description 代理和本体的一致性接口
 * @Author Heling
 * @Date 2019/8/21 12:47
 **/
public interface Printable {
    public abstract void setPrinterName(String name);
    public abstract String getPrinterName();
    public abstract void print(String string);

}

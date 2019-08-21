package Pattern.proxy;

/**
 * @Description ʹ����
 * @Author Heling
 * @Date 2019/8/21 12:47
 **/
public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("������ " + p.getPrinterName());
        p.setPrinterName("Bob");
        System.out.println("������ " + p.getPrinterName());
        p.print("hello world");
    }
}

package Pattern.bridge;
/**
* @Description: 桥接模式 main 使用示例
* @Author:  HeLing
* @Date: 2019/8/7 13:11
*/ 
public class Main {
    public static void main(String [] args){
        Display display1 = new Display(new StringDisplayImpl("Hello, heling"));
        CountDisplay display2 = new CountDisplay(new StringDisplayImpl("Hello, world"));
        CountDisplay display3 = new CountDisplay(new StringDisplayImpl("Hello, inmoto"));
        display1.display();
        display2.display();
        display3.display();
        display3.countDisplay(5);

        FileDisplayImpl fileDisplay = new FileDisplayImpl("C:\\Users\\heling\\Desktop\\新建文本文档 (2).txt");
        Display displayFile = new Display(fileDisplay);
        displayFile.display();

        CountDisplay countDisplay = new CountDisplay( new CharDisplayImpl("*"));
        countDisplay.reaptDispaly(5);
    }
}

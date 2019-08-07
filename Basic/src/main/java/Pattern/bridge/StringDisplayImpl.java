package Pattern.bridge;
/**
* @Description: �Ž�ģʽ ��㼶�ṹ ����ʵ����
* @Author:  HeLing
* @Date: 2019/8/7 13:16
*/ 
public class StringDisplayImpl extends DisplayImpl {
    private String string;
    private int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        width = string.getBytes().length;
    }

    public void rawOpen() {
        printline();
    }


    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    public void rawClose() {
        printline();
    }
    private void printline(){
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}

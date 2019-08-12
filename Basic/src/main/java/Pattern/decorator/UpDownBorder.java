package Pattern.decorator;

/**
 * @Description 练习1：上下边界的具体装饰类
 * @Author Heling
 * @Date 2019/8/12 17:47
 **/
public class UpDownBorder extends Border {
    private char borderchar;

    public UpDownBorder(Display display, char borderchar) {
        super(display);
        this.borderchar = borderchar;
    }

    public int getColumns() {
        return display.getColumns();
    }

    public int getRows() {
        return display.getRows() + 2;
    }

    public String getRowText(int row) {
        if(row == 0 ||
            row == (getRows() - 1) ) {
            return makeRow();
        }else{
            return display.getRowText(row-1);
        }
    }
    private String makeRow(){
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i <getColumns() ; i++) {
            buff.append(borderchar);
        }
        return buff.toString();
    }
}

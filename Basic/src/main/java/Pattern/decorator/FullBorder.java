package Pattern.decorator;

/**
 * @Description иооб╠ъ©Рв╟йн
 * @Author Heling
 * @Date 2019/8/12 11:37
 **/
public class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }

    public int getColumns() {
        return 2 + display.getColumns();
    }

    public int getRows() {
        return 2 + display.getRows();
    }

    public String getRowText(int row) {
        if(row == 0 ||
            row == display.getRows() + 1 ){
            return "+"  +  makeLine('-', display.getColumns()) + "+";
        }else{
            return "|" + display.getRowText(row-1) + "|";
        }
    }

    private String makeLine (char ch,int count){
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buff.append(ch);
        }
        return buff.toString();
    }
}

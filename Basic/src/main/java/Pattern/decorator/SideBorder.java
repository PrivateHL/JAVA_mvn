package Pattern.decorator;

/**
 * @Description ×óÓÒ±ß¿ò×°ÊÎ
 * @Author Heling
 * @Date 2019/8/12 11:36
 **/
public class SideBorder extends Border {
    private char borderChar;

    public SideBorder(Display display,char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    public int getColumns() {
        return 2+display.getColumns();
    }

    public int getRows() {
        return display.getRows();
    }

    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}

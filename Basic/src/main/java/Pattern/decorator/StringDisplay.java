package Pattern.decorator;

/**
 * @Description 装饰模式 具体的组件，实现抽象的特点
 * @Author Heling
 * @Date 2019/8/12 11:17
 **/
public class StringDisplay extends Display {
    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    public int getColumns() {
        return string.getBytes().length;
    }

    public int getRows() {
        return 1;
    }

    public String getRowText(int row) {
        if(row == 0){
            return string;
        }else{
            return  null;
        }
    }
}

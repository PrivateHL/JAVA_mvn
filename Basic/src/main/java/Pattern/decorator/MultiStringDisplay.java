package Pattern.decorator;

import java.util.ArrayList;

/**
 * @Description 练习2 多行String显示 具体组件
 * @Author Heling
 * @Date 2019/8/12 18:10
 **/
public class MultiStringDisplay extends Display {
    ArrayList altString = new ArrayList();
    private int columns ;

    public MultiStringDisplay() {
    }

    public void add(String line){

        altString.add(line);
        columns = line.getBytes().length > columns ? line.getBytes().length  : columns;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return altString.size();
    }

    public String getRowText(int row) {
        return (String) altString.get(row);
    }
}

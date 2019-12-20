package Tool.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * @Description
 * @Author Heling
 * @Date 2019/10/11 11:18
 **/
public class Out2Excel2003 extends AbstractOut2Excel {
    String strFilePathedName = "";

    FileOutputStream out = null;
    HSSFWorkbook wb = null; //创建工作表
    HSSFSheet sheet = null; //创建sheet
    HSSFCell cells[] = null; //单元格
    HSSFRow rows = null; //定义行变量，用来循环赋

    @Override
    protected boolean createWorkbench() {
        return false;
    }

    @Override
    protected boolean createWorkbench(String filePathedName) throws Exception {
        if (filePathedName == null) {
            return false;
        }
        strFilePathedName = filePathedName;
        if(out == null) {
            out = new FileOutputStream(strFilePathedName); //输出流
        }
        if(wb == null) {
            wb = new HSSFWorkbook(); //创建工作表
        }
        return false;
    }

    @Override
    protected boolean createSheet(String sheetName) {
        return false;
    }

    @Override
    protected boolean createCell(Object value, int wilden) {
        return false;
    }

    @Override
    protected boolean createRow(ArrayList<Object> rowData) {
        return false;
    }
}

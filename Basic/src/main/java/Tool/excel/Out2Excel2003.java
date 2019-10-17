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
    HSSFWorkbook wb = null; //����������
    HSSFSheet sheet = null; //����sheet
    HSSFCell cells[] = null; //��Ԫ��
    HSSFRow rows = null; //�����б���������ѭ����

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
            out = new FileOutputStream(strFilePathedName); //�����
        }
        if(wb == null) {
            wb = new HSSFWorkbook(); //����������
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

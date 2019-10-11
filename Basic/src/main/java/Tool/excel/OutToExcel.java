package Tool.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * @Description 导出信息到excel
 * @Author Heling
 * @Date 2019/10/10 18:27
 **/
public class OutToExcel  {
    private ArrayList altData = null;
    private String filePathedName = null;
    String title = "";

    FileOutputStream out = null;
    HSSFWorkbook wb = null; //创建工作表
    HSSFSheet sheet = null; //创建sheet
    HSSFCell cells[] = null; //单元格
    HSSFRow rows = null; //定义行变量，用来循环赋

    int pageMaxRow = 2500;

    public OutToExcel(ArrayList altData, String filePathedName, String title) {
        this.altData = altData;
        this.filePathedName = filePathedName;
        this.title = title;
    }

    public boolean doOutExcel(){
        if (filePathedName == null) {
            return false;
        }
        int dealingRow = 0;

        if (filePathedName != null && filePathedName.indexOf("\"") > -1) { //$NON-NLS-1$
            JOptionPane.showMessageDialog(null,"错误文件名"); //$NON-NLS-1$ //$NON-NLS-2$
            return false;
        }

        if(out == null) {
            try {
                out = new FileOutputStream(filePathedName); //输出流
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(wb == null) {
            wb = new HSSFWorkbook(); //创建工作表
        }
        if(sheet == null) {
            sheet = wb.createSheet(); //创建sheet
        }

        for (int ir = 0; ir < this.altData.size(); ir++) {
            rows = sheet.createRow( (short) ++dealingRow);
            String data[] = ( (String[]) altData.get(ir));
            cells = new HSSFCell[data.length ];//定义单元格变量，用来循环赋值
            for (int ii = 0; ii < ( (String[]) altData.get(ir)).length; ii++) {
                cells[ii] = rows.createCell( (short) ii);
               // cells[ii].setCellStyle(headerCS);
                try {
                    cells[ii].setCellValue(data[ii]);
                }
                catch (Exception ex) {
                }
            }
            int ii = 2 + ir;
            int jj = 3 + ir;
            if(dealingRow >= 32768 && dealingRow % 32768 == 0){
                sheet =  wb.createSheet(); //创建sheet
                dealingRow = 0;
            }
        }
        try {
            wb.write(out); //输出流到电子表格
            out.close(); //关闭对文件的使用
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (out != null) {
                try {
                    out.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}

package Tool.excel;

import java.util.ArrayList;

/**
 * @Description
 * @Author Heling
 * @Date 2019/10/11 9:18
 **/
abstract class AbstractOut2Excel {
    String errorInfo = "";
    String logInfo = "";
    /**
     * @Description: 创建POI workbench工作簿
     * @param:    filePathedName 完整的输出文件路径
     * @return:
     * @Author:  HeLing  2019/10/11 9:25
     */
    protected  boolean createWb(String filePathedName) throws Exception{
        if (filePathedName.endsWith(".xls")){

        }else if(filePathedName.endsWith(".xlsx")){

        }else{
            errorInfo = "输出文件指定错误的文件格式，请额外指定";
            throw new FileFormatInvalid(errorInfo);
        }
        return false;
    }

    protected abstract boolean createWorkbench();

    protected abstract boolean createWorkbench(String filePathedName) throws Exception;

    protected abstract boolean createSheet(String sheetName);

    protected abstract boolean createCell(Object value, int wilden);//可能需要合并单元格

    protected abstract boolean createRow(ArrayList<Object> rowData);//普通的一行数据写入


    protected  String getErrorInfo(){
        return errorInfo;
    }
}

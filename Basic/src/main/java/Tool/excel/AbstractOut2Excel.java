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
    * @Description: ����POI workbench������
    * @param:    filePathedName ����������ļ�·��
    * @return:
    * @Author:  HeLing  2019/10/11 9:25
    */
    protected  boolean createWb(String filePathedName) throws Exception{
        if (filePathedName.endsWith(".xls")){

        }else if(filePathedName.endsWith(".xlsx")){

        }else{
            errorInfo = "����ļ�ָ��������ļ���ʽ�������ָ��";
            throw new FileFormatInvalid(errorInfo);
        }
        return false;
    }

    protected abstract boolean createWorkbench();

    protected abstract boolean createWorkbench(String filePathedName) throws Exception;

    protected abstract boolean createSheet(String sheetName);

    protected abstract boolean createCell(Object value, int wilden);//������Ҫ�ϲ���Ԫ��

    protected abstract boolean createRow(ArrayList<Object> rowData);//��ͨ��һ������д��


    protected  String getErrorInfo(){
        return errorInfo;
    }
}

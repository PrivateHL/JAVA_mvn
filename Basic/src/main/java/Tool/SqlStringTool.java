package Tool;

public class SqlStringTool {

    /**
     * 加上 N 代表存入数据库时以 Unicode 格式存储。  N'string' 表示string是个Unicode字符串
     * @param sql
     * @return
     */
    public static String setNvarcharSql(String sql){
        boolean isContent = false;
        int start = ( sql.toUpperCase().indexOf("INSERT") == -1 &&  sql.toUpperCase().indexOf("UPDATE") ==-1) ? sql.length() : 6;
        int end = sql.length();
        StringBuilder newSql = new StringBuilder( sql.substring(0,start));

        for(int i = start; i < end; i++){
            if((i+3) <= end && "'''".equals(sql.substring(i,i+3))){
                newSql.append( isContent || sql.charAt(i-1)=='N'? "'''":"N'''");
                isContent = !isContent;
                i += 2;
                continue;
            }
            if((i+2) <= end && "''".equals(sql.substring(i,i+2))){
                newSql.append(isContent|| sql.charAt(i-1)=='N'?"''":"N''");
                i += 1;
                continue;
            }
            if("'".equals( sql.substring(i,i+1) )){
                newSql.append(isContent|| sql.charAt(i-1)=='N'?"'":"N'");
                isContent = !isContent;
                continue;
            }
            newSql.append(sql.charAt(i));

        }
        return newSql.toString();
    }

}

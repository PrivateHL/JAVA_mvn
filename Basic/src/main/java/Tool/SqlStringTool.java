package Tool;

public class SqlStringTool {

    /**
     * 加上 N 代表存入数据库时以 Unicode 格式存储。  N'string' 表示string是个Unicode字符串
     * 单引号为转义字符
     * @param sql
     * @return
     */
    public static String setNvarcharSql(String sql){
        int start = ( sql.toUpperCase().indexOf("INSERT") == -1 &&  sql.toUpperCase().indexOf("UPDATE") ==-1 && sql.toUpperCase().indexOf("SELECT") ==-1) ? sql.length() : 6;
        int end = sql.length();
        StringBuilder newSql = new StringBuilder( sql.substring(0,start));

        boolean isText = false;//标记当前的i位置是否为文本内容
        for(int i = start; i < end; i++){
            String chars = "";
            if('\'' == sql.charAt(i)){
                if(isText){
                    if ((i+1) < end && '\'' == sql.charAt(i+1)){//内容 注释的单引号
                        i++;//跳过下一个字符
                        chars = "\'\'";
                        isText = true;
                    }else{//内容结尾 单引号
                        isText = false;
                        chars = "\'";
                    }
                }else{//内容开始 单引号
                    if ('N' != sql.charAt(i-1)){
                        chars = "N\'";//没有前置过N，前置
                    }
                    isText = true;
                }
            }
            if ("".equalsIgnoreCase(chars)){
                chars = String.valueOf( sql.charAt(i) );
            }
            newSql.append(chars);
        }
        return newSql.toString();
    }

}

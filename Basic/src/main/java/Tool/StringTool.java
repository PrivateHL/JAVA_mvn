package Tool;

import com.sun.xml.internal.ws.util.StringUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTool {

    /** 值为"NULL"的字符串 */
    private static final String NULL_STRING = "NULL";

    private static final char SEPARATOR = '_';


    /**
     * 满足一下情况返回true<br/>
     * ①.入参为空
     * ②.入参为空字符串
     * ③.入参为"null"字符串
     *
     * @param string 需要判断的字符型
     * @return boolean
     */
    public static boolean isNullOrEmptyOrNULLString(String string) {
        return isBlank(string) || NULL_STRING.equalsIgnoreCase(string);
    }

    /**
     * 把字符串转为二进制码<br/>
     * 本方法不会返回null
     *
     * @param str 需要转换的字符串
     * @return 二进制字节码数组
     */
    public static byte[] toBytes(String str) {
        return isBlank(str) ? new byte[]{} : str.getBytes();
    }

    /**
     * 把字符串转为int类型
     *
     * @param str 需要转化的字符串
     * @return int
     * @throws NumberFormatException 字符串格式不正确时抛出
     */
    public static int parseInt(String str) throws NumberFormatException {
        return isBlank(str) ? 0 : Integer.parseInt(str);
    }

    /**
     * 把字符串转为double类型
     *
     * @param str 需要转化的字符串
     * @return double
     * @throws NumberFormatException 字符串格式不正确时抛出
     */
    public static double parseDouble(String str) throws NumberFormatException {
        return isBlank(str) ? 0D : Double.parseDouble(str);
    }

    /**
     * 把字符串转为long类型
     *
     * @param str 需要转化的字符串
     * @return long
     * @throws NumberFormatException 字符串格式不正确时抛出
     */
    public static long parseLong(String str) throws NumberFormatException {
        return isBlank(str) ? 0L : Long.parseLong(str);
    }

    /**
     * 把字符串转为float类型
     *
     * @param str 需要转化的字符串
     * @return float
     * @throws NumberFormatException 字符串格式不正确时抛出
     */
    public static float parseFloat(String str) throws NumberFormatException {
        return isBlank(str) ? 0L : Float.parseFloat(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                // 判断字符是否为空格、制表符、tab
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     * 判断是否为空字符串最优代码
     * @param str
     * @return 如果为空，则返回true
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断字符串是否非空
     * @param str 如果不为空，则返回true
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    public static boolean validTime(String time) {
        if (time == null || time.equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(
                "^([0-1][0-9]|2[0-3])(:[0-5][0-9]){2}|([0-1][0-9]|2[0-3])(:[0-5][0-9]):60|([0-1][0-9]|2[0-3]):60:00|24:00:00");
        Matcher matcher = pattern.matcher(time);
        return matcher.matches() ? true : false;
    }
}

package Tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumTool {

    public static int smaller(int num1, int num2, int smallest, int biggest){
        if(smallest >= biggest ){
            return num1 >= num2 ? num2 : num1;
        }
        int a = (num1 <= smallest? smallest : num1) <  biggest ?   (num1 <= smallest? smallest : num1) : biggest;
        int b = (num2 <= smallest? smallest : num2) <  biggest ?   (num2 <= smallest? smallest : num2) : biggest;
        return a <= b ? a : b;
    }
    public static boolean isNumber(String num) {
        try {
            Double.parseDouble(num);
        }
        catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static boolean isInt(String num) {
        Pattern pattern = Pattern.compile("^\\d*$");
        Matcher matcher = pattern.matcher(num.toString());
        return matcher.matches() ? true : false;
    }
}

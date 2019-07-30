package Basic;

import java.util.Collection;
import java.util.Map;

public class ValueWidget {

    /** 
    * @Description:  �ж϶����Ƿ�Ϊnull,�ַ�Ϊ���ַ���������Ϊÿ�������Ƿ�Ϊ�գ����϶����Ƿ���empty  
    * @param:   [obj] 
    * @return:  boolean 
    * @Author:  HeLing
    * @Date: 2019/7/30 13:39
    */ 
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null)
            return true;

        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;

        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();

        if (obj instanceof Map)
            return ((Map) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isNullOrEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }

        return false;
    }

    /** 
    * @Description: �ַ����Ƿ���ֵ
    * @param:   [input] 
    * @return:  boolean 
    * @Author:  HeLing
    * @Date: 2019/7/30 13:40
    */ 
    public static boolean isHasValue(String input) {
        if (null != input && !"".equals(input)) {
            return true;
        }
        return false;
    }

    /** 
    * @Description: �Ƿ��ǿո�
    * @param:   [c] 
    * @return:  boolean
    * @Author:  HeLing
    * @Date: 2019/7/30 13:43
    */ 
    public static boolean isBlank(char c) {
        int number22 = (int) c;
//		System.out.println(number22);
        if(number22==32/*�ո�*/||number22==9/*Tab*/
                ||number22==10/*\n*/||number22==13/*\r*/){
            return true;
        }
        return false;
    }
}

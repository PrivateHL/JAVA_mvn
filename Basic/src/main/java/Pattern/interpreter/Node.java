package Pattern.interpreter;


/**
 * @Description �����������
 * @Author Heling
 * @Date 2019/8/21 17:32
 **/
public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}

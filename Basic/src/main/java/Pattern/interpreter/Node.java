package Pattern.interpreter;


/**
 * @Description 抽象的语句对象
 * @Author Heling
 * @Date 2019/8/21 17:32
 **/
public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}

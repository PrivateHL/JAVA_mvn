package Pattern.interpreter;


/**
 * @Description
 * @Author Heling
 * @Date 2019/8/21 17:34
 **/
public class CommandNode extends Node {
    private Node node;

    public void parse(Context context) throws ParseException {
        if(context.currentToken().equals("repeat")){
            node = new RepeatCommandNode();
            node.parse(context);
        }else{
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }

    @Override
    public String toString() {
        return "CommandNode{" +
                "node=" + node +
                '}';
    }
}

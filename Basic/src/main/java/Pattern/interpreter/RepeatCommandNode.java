package Pattern.interpreter;

/**
 * @Description ����������� ѭ����
 * @Author Heling
 * @Date 2019/8/21 17:33
 **/
public class RepeatCommandNode extends Node{
    private int number;
    private Node commandListNode;
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "RepeatCommandNode{" +
                "number=" + number +
                ", commandListNode=" + commandListNode +
                '}';
    }
}

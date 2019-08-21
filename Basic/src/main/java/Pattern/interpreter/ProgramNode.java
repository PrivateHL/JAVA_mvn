package Pattern.interpreter;

/**
 * @Description ����������ɶ���-������
 * @Author Heling
 * @Date 2019/8/21 17:33
 **/
public class ProgramNode extends Node {
    private Node commandListNode;
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "ProgramNode{" +
                "commandListNode=" + commandListNode +
                '}';
    }
}

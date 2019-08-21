package Pattern.interpreter;

/**
 * @Description 迷你语言组成对象-函数体
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

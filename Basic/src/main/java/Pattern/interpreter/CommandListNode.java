package Pattern.interpreter;

import java.util.ArrayList;

/**
 * @Description 命令集合对象，在上下文中被使用保存非终结语句的内部命令集合
 * {开始的地方生成命令集合对象 添加、添加...  }结束的时候，将集合保存在非终结语句中
 * @Author Heling
 * @Date 2019/8/21 17:35
 **/
public class CommandListNode extends Node {
    private ArrayList list = new ArrayList();

    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() != null) {
                throw new ParseException("missing end");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            }else{
                Node comandNode = new CommandNode();
                comandNode.parse(context);
                list.add(comandNode);
            }
        }
    }

    @Override
    public String toString() {
        return "CommandListNode{" +
                "list=" + list +
                '}';
    }
}

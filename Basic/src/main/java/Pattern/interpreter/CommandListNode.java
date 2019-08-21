package Pattern.interpreter;

import java.util.ArrayList;

/**
 * @Description ����϶������������б�ʹ�ñ�����ս������ڲ������
 * {��ʼ�ĵط���������϶��� ��ӡ����...  }������ʱ�򣬽����ϱ����ڷ��ս������
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

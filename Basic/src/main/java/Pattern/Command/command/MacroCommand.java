package Pattern.Command.command;

import java.awt.color.CMMException;
import java.util.Iterator;
import java.util.Stack;

/**
 * @Description 命令发动着 发动命令
 * @Author Heling
 * @Date 2019/8/21 13:40
 **/
public class MacroCommand implements Command {
    private  Stack commands = new Stack();
    public void execute() {
        Iterator it = commands.iterator();
        while(it.hasNext()){{
            ((Command) it.next()).execute();
        }}
    }
    public void append(Command cmd){
        if(cmd != this){
            commands.push(cmd);
        }
    }
    public void undo(){
        if(!commands.empty()){
            commands.pop();
        }
    }
    public void clear(){
        commands.clear();
    }
}

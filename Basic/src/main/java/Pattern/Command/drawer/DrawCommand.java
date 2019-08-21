package Pattern.Command.drawer;

import Pattern.Command.command.Command;

import java.awt.*;

/**
 * @Description 绘制一个点的命令，命令接受者
 * @Author Heling
 * @Date 2019/8/21 13:40
 **/
public class DrawCommand implements Command {
    protected Drawable drawable;
    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    public void execute() {
        drawable.draw(position.x, position.y);
    }
}

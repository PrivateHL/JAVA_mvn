package Pattern.Command.drawer;

import Pattern.Command.command.Command;

import java.awt.*;

/**
 * @Description 练习1
 * @Author Heling
 * @Date 2019/8/21 16:32
 **/
public class ColorCommand implements Command {
    protected Drawable drawable;
    private Color color;

    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    public void execute() {
        drawable.setColor(color);
    }
}

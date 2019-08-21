package Pattern.Command.drawer;

import Pattern.Command.command.MacroCommand;

import java.awt.*;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/21 13:52
 **/
public class DrawCanvas extends Canvas implements Drawable {
    private Color color ;
    private int radius;
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.WHITE);
        this.history = history;
        init();
    }

    public void init(){
        color = Color.RED;
        radius = 6;
        history.append(new ColorCommand(this,color));//这个很细节，初始化的颜色也加入一个命令。高手就是不一样
    }
    public void paint(Graphics g) {
        history.execute();
    }

    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

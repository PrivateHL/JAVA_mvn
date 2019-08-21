package Pattern.Command.drawer;

import java.awt.*;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/21 13:41
 **/
public interface Drawable {
    public abstract void draw(int x,int y);
    public abstract void setColor(Color color);

}

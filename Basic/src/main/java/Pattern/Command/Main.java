package Pattern.Command;

import Pattern.Command.command.Command;
import Pattern.Command.command.MacroCommand;
import Pattern.Command.drawer.DrawCanvas;
import Pattern.Command.drawer.DrawCommand;

import javax.swing.*;
import java.awt.event.*;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/21 13:42
 **/
public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton buttonClear = new JButton("clear");
    private JButton buttonUndo = new JButton("undo");

    public Main(String title) {
        super(title);
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        buttonClear.addActionListener(this);
        buttonUndo.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(buttonClear);
        buttonBox.add(buttonUndo);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

    public static void main(String[] args) {
        new Main("command pattern sample");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonClear) {
            history.clear();
            canvas.repaint();
        }else if (e.getSource() == buttonUndo){//撤销
            history.undo();
            canvas.repaint();//会调用canvas的paint方法
        }
    }

    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    public void mouseMoved(MouseEvent e) {

    }

    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {

    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {

    }
}

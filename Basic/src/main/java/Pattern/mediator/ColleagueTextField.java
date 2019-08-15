package Pattern.mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/15 12:39
 **/
public class ColleagueTextField extends TextField implements TextListener,Colleague {
    private Mediator mediator;

    public ColleagueTextField(String text, int columns) throws HeadlessException {
        super(text, columns);
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled? Color.WHITE : Color.LIGHT_GRAY);
    }
    public  void textValueChanged(TextEvent e){
        mediator.colleagueChanged();
    }
}

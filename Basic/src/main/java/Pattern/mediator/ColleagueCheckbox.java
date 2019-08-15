package Pattern.mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/15 12:43
 **/
public class ColleagueCheckbox extends Checkbox  implements ItemListener,  Colleague {
    private  Mediator mediator;

    public ColleagueCheckbox(String label, CheckboxGroup group, boolean state) throws HeadlessException {
        super(label, group, state);
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {
        mediator.colleagueChanged();
    }

    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
    }
}

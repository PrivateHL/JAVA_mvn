package Pattern.mediator;

import java.awt.*;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/15 12:34
 **/
public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    public ColleagueButton(String label) throws HeadlessException {
        super(label);
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}

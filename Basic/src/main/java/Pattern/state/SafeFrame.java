package Pattern.state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description ����״̬�Ķ���
 * @Author Heling
 * @Date 2019/8/19 18:55
 **/
public class SafeFrame extends Frame implements ActionListener, Context {

    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10,60);
    private Button buttonUse = new Button("ʹ�ý��");
    private Button buttonAlarm = new Button("���¾���");
    private Button buttonPhone = new Button("����ͨ��");
    private Button buttonExit = new Button("����");

    private State state = DayState.getInstance();

    public SafeFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        add(textClock,BorderLayout.NORTH);
        textClock.setEditable(false);
        add(textScreen,BorderLayout.CENTER);
        textScreen.setEditable(false);

        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);

        add(panel,BorderLayout.SOUTH);
        pack();
        show();

        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    public void setClock(int hour) {
        String clockstring = "����ʱ����";
        if(hour < 10){
            clockstring += "0" + hour + ":00";
        }else{
            clockstring += hour + ":00";
        }
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this,hour);
    }

    public void changeState(State state) {
        System.out.println("��" + this.state + "״̬��Ϊ��" + state + "״̬��");
        this.state = state;
    }

    public void callSecurityCenter(String msg) {
        textScreen.append("CALL!" + msg + "\n");
    }

    public void recordingLog(String msg) {
        textScreen.append("recording ... " + msg + "\n");
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if(e.getSource() == buttonUse){
            state.doUse(this);
        }else if(e.getSource() == buttonAlarm){
            state.doAlarm(this);
        }else if(e.getSource() == buttonPhone){
            state.doPhone(this);
        }else if(e.getSource() == buttonExit){
            System.exit(0);
        }else{
            System.out.println("?");
        }
    }
}

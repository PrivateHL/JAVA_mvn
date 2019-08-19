package Pattern.state;

/**
 * @Description �����״̬
 * @Author Heling
 * @Date 2019/8/19 18:52
 **/
public class NightState implements State {
    private static  NightState singleton = new NightState();
    private NightState(){}

    public static State getInstance(){
        return singleton;
    }
    public void doClock(Context context, int hour) {
        if(hour < 9 || 17 <= hour){
            context.changeState(DayState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.recordingLog("ʹ�ý�⣨���ϣ�");
    }

    public void doAlarm(Context context) {
        context.callSecurityCenter("���¾��壨���ϣ�");
    }

    public void doPhone(Context context) {
        context.callSecurityCenter("ͨ��¼�������ϣ�");
    }

    @Override
    public String toString() {
        return "����";
    }
}

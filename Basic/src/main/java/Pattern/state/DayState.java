package Pattern.state;

/**
 * @Description ����״̬
 * @Author Heling
 * @Date 2019/8/19 18:47
 **/
public class DayState implements State {
    private static  DayState singleton = new DayState();
    private DayState(){}

    public static State getInstance(){
        return singleton;
    }
    public void doClock(Context context, int hour) {
        if(hour < 9 || 17 <= hour){
            context.changeState(NightState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.recordingLog("ʹ�ý�⣨���죩");
    }

    public void doAlarm(Context context) {
        context.callSecurityCenter("���¾��壨���죩");
    }

    public void doPhone(Context context) {
        context.callSecurityCenter("����ͨ�������죩");
    }

    @Override
    public String toString() {
        return "����";
    }
}

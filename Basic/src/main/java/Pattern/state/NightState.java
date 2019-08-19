package Pattern.state;

/**
 * @Description 具体的状态
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
        context.recordingLog("使用金库（晚上）");
    }

    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃（晚上）");
    }

    public void doPhone(Context context) {
        context.callSecurityCenter("通话录音（晚上）");
    }

    @Override
    public String toString() {
        return "晚上";
    }
}

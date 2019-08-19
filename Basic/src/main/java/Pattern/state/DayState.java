package Pattern.state;

/**
 * @Description 具体状态
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
        context.recordingLog("使用金库（白天）");
    }

    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃（白天）");
    }

    public void doPhone(Context context) {
        context.callSecurityCenter("正常通话（白天）");
    }

    @Override
    public String toString() {
        return "白天";
    }
}

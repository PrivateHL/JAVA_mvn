package Pattern.state;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/19 19:22
 **/
public class LaunchState implements State {
    private static LaunchState singleton = new LaunchState();
    private LaunchState(){}
    public static LaunchState getInstance(){
        return singleton;
    }
    public void doClock(Context context, int hour) {
        if(hour < 9 || 17 <= hour){
            context.changeState(NightState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.callSecurityCenter("");
    }

    public void doAlarm(Context context) {
        context.callSecurityCenter("");
    }

    public void doPhone(Context context) {
        context.recordingLog("");
    }
}

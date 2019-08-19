package Pattern.state;

public interface State {
    public abstract void doClock(Context context,int hour);// set time
    public abstract void doUse(Context context);// use
    public abstract void doAlarm(Context context);// alarm
    public abstract void doPhone(Context context);// make a call
}

package JVM;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    public void isAlive(){
        System.out.println("YES,i am still alive.");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }
    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒等它执行
        Thread.sleep(500);
        if( SAVE_HOOK == null ){
            System.out.println("NO, i am dead.");
        }
        else{
            SAVE_HOOK.isAlive();
        }

        //再一次回收，就会拯救失败 因为finalize不再执行
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒等它执行
        Thread.sleep(500);
        if( SAVE_HOOK == null ){
            System.out.println("NO, i am dead.");
        }
        else{
            SAVE_HOOK.isAlive();
        }
    }
}

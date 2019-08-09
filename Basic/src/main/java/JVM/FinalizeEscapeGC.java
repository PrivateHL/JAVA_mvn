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
        //�����һ�γɹ������Լ�
        SAVE_HOOK = null;
        System.gc();
        //��Ϊfinalize�������ȼ��ܵͣ�������ͣ0.5�����ִ��
        Thread.sleep(500);
        if( SAVE_HOOK == null ){
            System.out.println("NO, i am dead.");
        }
        else{
            SAVE_HOOK.isAlive();
        }

        //��һ�λ��գ��ͻ�����ʧ�� ��Ϊfinalize����ִ��
        SAVE_HOOK = null;
        System.gc();
        //��Ϊfinalize�������ȼ��ܵͣ�������ͣ0.5�����ִ��
        Thread.sleep(500);
        if( SAVE_HOOK == null ){
            System.out.println("NO, i am dead.");
        }
        else{
            SAVE_HOOK.isAlive();
        }
    }
}

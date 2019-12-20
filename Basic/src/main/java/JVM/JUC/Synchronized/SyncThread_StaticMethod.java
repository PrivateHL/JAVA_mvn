package JVM.JUC.Synchronized;

/**
 * 同步线程,修饰静态方法
 * 静态同步方法，锁是当前类的class对象
 */
public class SyncThread_StaticMethod implements Runnable{

    private static int count;

    public SyncThread_StaticMethod() {
        count = 0;
    }

    public synchronized static void method() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method2() {
        synchronized(SyncThread_StaticMethod.class) {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        //method();
        method2();
    }

    public static void main(String [] args){
        /** 静态方法是属于类的，所以syncThread1和syncThread2相当于用了同一把锁
         修饰静态方法，和在方法里面修饰（class）是同样的锁效果**/
        SyncThread_StaticMethod syncThread1 = new SyncThread_StaticMethod();
        SyncThread_StaticMethod syncThread2 = new SyncThread_StaticMethod();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
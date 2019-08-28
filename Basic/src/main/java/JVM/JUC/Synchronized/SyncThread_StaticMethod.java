package JVM.JUC.Synchronized;

/**
 * ͬ���߳�,���ξ�̬����
 * ��̬ͬ�����������ǵ�ǰ���class����
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
        /** ��̬������������ģ�����syncThread1��syncThread2�൱������ͬһ����
            ���ξ�̬���������ڷ����������Σ�class����ͬ������Ч��**/
        SyncThread_StaticMethod syncThread1 = new SyncThread_StaticMethod();
        SyncThread_StaticMethod syncThread2 = new SyncThread_StaticMethod();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
 }
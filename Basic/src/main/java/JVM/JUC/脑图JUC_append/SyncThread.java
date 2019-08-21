/**
 * 同步线程
 当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized代码块时，
 在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后才能执行该代码块。
 **/
public class SyncThread implements Runnable {
   private static int scount;
   private int icount;
 
   public SyncThread() {
      scount = 0;
      icount = 0;
   }
   
   public void run() {
      String threadName = Thread.currentThread().getName();
      if (threadName.startsWith("tread_sync_s")) {
         scountAdd_sync();
      } else if (threadName.startsWith("tread_sync_i")) {
         icountAdd_sync();
      }else if (threadName.startsWith("tread_nons_s")) {
         scountPrint();
      }else if (threadName.startsWith("tread_nons_i")) {
         icountPrint();
      }
   }
 
   public  void scountAdd_sync() {
      synchronized(this) {
         for (int i = 0; i < 5; i++) {
            try {
               System.out.println(Thread.currentThread().getName() + ":" + (scount++));
               Thread.sleep(100);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }
   
   public  void icountAdd_sync() {
      synchronized(this) {
         for (int i = 0; i < 5; i++) {
            try {
               System.out.println(Thread.currentThread().getName() + ":" + (icount++));
               Thread.sleep(100);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }
   
   //非synchronized代码块，未对静态变量scount进行读写操作，所以可以不用synchronized
   public void scountPrint() {
      for (int i = 0; i < 5; i ++) {
         try {
            System.out.println(Thread.currentThread().getName() + " scount:" + scount);
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   
   //非synchronized代码块，未对实例变量count进行读写操作，所以可以不用synchronized
   public void icountPrint() {
      for (int i = 0; i < 5; i ++) {
         try {
            System.out.println(Thread.currentThread().getName() + " icount:" + icount);
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
 
   public int getsCount() {
      return scount;
   }
   
   public static void main(String [] args){
        /**
        *同一个对象
        *Thread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前的对象，
        *只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象.
        **/
        System.out.println("Part ONE :\nOne instance is concurrent");
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "tread_sync_s1");
        Thread thread2 = new Thread(syncThread, "tread_sync_s2");
        thread1.start();
        thread2.start();
        
        try {
               Thread.sleep(2000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        /**
        *两个不同的对象
        *不会受到影响，因为锁的是class的对象实例，不同的对象实例，不同的锁
        *有时候会打印到同样的值：静态变量是class拥有，class没有锁，导致两个实例获取的值是同一个
        **/
        System.out.println("\nPart TWO:\nDifferent instances are not concurrent");
        Thread thread3 = new Thread(new SyncThread(), "tread_sync_s3");
        Thread thread4 = new Thread(new SyncThread(), "tread_sync_s4");
        thread3.start();
        thread4.start();
        
        try {
               Thread.sleep(2000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        /**
        *一个线程访问一个对象的synchronized代码块时，别的线程可以访问该对象的非synchronized代码块而不受阻塞
        **/
        System.out.println("\nPart THREE:\nONE instance concurrent and nonConcurrent");
        SyncThread syncThread3 = new SyncThread();
        Thread thread5 = new Thread(syncThread3, "tread_sync_i5");
        Thread thread6 = new Thread(syncThread3, "tread_nons_i6");
        thread5.start();
        thread6.start();
        
        try {
               Thread.sleep(2000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        /**
        *一个线程访问一个对象的synchronized代码块时，别的线程可以访问该对象的非synchronized代码块而不受阻塞
        **/
        System.out.println("\nPart FOUR:\nONE instance concurrent and nonConcurrent");
        SyncThread syncThread4 = new SyncThread();
        Thread thread7 = new Thread(syncThread3, "tread_sync_s7");
        Thread thread8 = new Thread(syncThread3, "tread_nons_s8");
        thread7.start();
        thread8.start();
   }
}
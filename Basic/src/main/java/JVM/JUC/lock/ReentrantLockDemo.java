package JVM.JUC.lock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 重入锁的使用方法
 * @Author Heling
 * @Date 2019/8/28 9:36
 **/
public class ReentrantLockDemo extends Thread {
    public static ReentrantLock lock = new ReentrantLock();
    public static ReentrantLock lock1 = new ReentrantLock();//测试中断，需要lock2和lock1相互死锁
    public static ReentrantLock lock2 = new ReentrantLock();
    public static int i = 0;

    /**
     * 测试的类型：1-普通锁；2-重入锁；3-限时锁; 4/5互相死锁，测试中断
     **/
    private int type;

    public ReentrantLockDemo(String name, int type) {
        super(name);
        this.type = type;
    }

    @Override
    public void run() {
        if (type == 1) {
            lockNormal();
        } else if (type == 2) {
            lockTimes();
        } else if (type == 3) {
            lockTimelimit();
        } else if (type == 4 || type == 5) {
            lockInterrupt();
        }
    }


    /**
     * @Description: 普通的获取锁，释放锁
     * @param: []
     * @return: void
     * @Author: HeLing
     * @Date: 2019/8/28 10:06
     */
    private void lockNormal() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try {
                System.out.println(this.getName() + " " + i);
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * @Description: 重入锁，多次获得锁
     * 重入锁内部有一个获得锁相关的计数器，lock就+1，unlock-1释放对应的lock次数才能真正释放。
     * @param: []
     * @return: void
     * @Author: HeLing  2019/8/28 10:10
     */
    private void lockTimes() {
        lock.lock();
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    /**
     * @Description: 限时锁，限定固定的时间获取锁，超时就返回，不会一直等待在获取锁的队列中
     * @param: []
     * @return: void
     * @Author: HeLing  2019/8/28 10:23
     */
    private void lockTimelimit() {

        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            } else {
                System.out.println(this.getName() + " get lock failed");
            }
        } catch (Exception e) {
        } finally {
            if (lock.isHeldByCurrentThread()) {
                System.out.println("lock.isHeldByCurrentThread: " + this.getName());
                lock.unlock();
            }
        }
    }

    private void lockInterrupt() {
        try {
            if (type == 4) {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                lock2.lockInterruptibly();
            } else if (type == 5) {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                lock1.lockInterruptibly();
            }
        } catch (Exception e) {

        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + "线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         //普通锁测试
         ReentrantLockDemo demo1 = new ReentrantLockDemo("T1", 1);
         ReentrantLockDemo demo2 = new ReentrantLockDemo("T2", 1);
         ReentrantLockDemo demo3 = new ReentrantLockDemo("T3", 1);
         ReentrantLockDemo demo4 = new ReentrantLockDemo("T4", 1);
         ReentrantLockDemo demo5 = new ReentrantLockDemo("T5", 1);

         demo1.start();
         demo2.start();
         demo3.start();
         demo4.start();
         demo5.start();
         demo1.join();//主线程等待子线程执行完再执行
         demo2.join();
         demo3.join();
         demo4.join();
         demo5.join();
         System.out.println(i);


         //限时锁
         ReentrantLockDemo demo6 = new ReentrantLockDemo("timelimitThread1",3);
         ReentrantLockDemo demo7 = new ReentrantLockDemo("timelimitThread2",3);
         demo6.start();
         demo7.start();
         **/
        //死锁 中断测试
        ReentrantLockDemo demo8 = new ReentrantLockDemo("lockInterrupt1" ,4);
        ReentrantLockDemo demo9 = new ReentrantLockDemo("lockInterrupt2" ,5);
        demo8.start();
        demo9.start();
        Thread.sleep(1000);
        // DeadlockChecker.check();
    }

    /**
     * 死锁检查器，4/5会互相死锁，检测到后执行interrupt中断
     */
    static class DeadlockChecker{

        private final static ThreadMXBean mbean = ManagementFactory.getThreadMXBean();

        public static void check(){
            Thread tt = new Thread(){
                @Override
                public void run() {
                    while(true){
                        long[] deadlockedThreadsIds = mbean.findDeadlockedThreads();
                        if(deadlockedThreadsIds != null ){
                            ThreadInfo[] threadInfos = mbean.getThreadInfo(deadlockedThreadsIds);
                            for( Thread t : Thread.getAllStackTraces().keySet()){
                                for (int j = 0; j < threadInfos.length ; j++) {
                                    if(t.getId() == threadInfos[j].getThreadId()){
                                        System.out.println(t.getName() + " is Find deadlocked");
                                        t.interrupt();
                                    }

                                }
                            }
                        }
                        try{
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            //设置为守护线程--也称“服务线程”，在没有用户线程可服务时会自动离开。优先级：守护线程的优先级比较低，用于为系统中的其它对象和线程提供服务。
            tt.setDaemon(true);
            tt.start();
        }
    }
}

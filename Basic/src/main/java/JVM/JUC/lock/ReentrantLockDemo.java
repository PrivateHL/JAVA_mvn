package JVM.JUC.lock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description ��������ʹ�÷���
 * @Author Heling
 * @Date 2019/8/28 9:36
 **/
public class ReentrantLockDemo extends Thread {
    public static ReentrantLock lock = new ReentrantLock();
    public static ReentrantLock lock1 = new ReentrantLock();//�����жϣ���Ҫlock2��lock1�໥����
    public static ReentrantLock lock2 = new ReentrantLock();
    public static int i = 0;

    /**
     * ���Ե����ͣ�1-��ͨ����2-��������3-��ʱ��; 4/5���������������ж�
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
     * @Description: ��ͨ�Ļ�ȡ�����ͷ���
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
     * @Description: ����������λ����
     * �������ڲ���һ���������صļ�������lock��+1��unlock-1�ͷŶ�Ӧ��lock�������������ͷš�
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
     * @Description: ��ʱ�����޶��̶���ʱ���ȡ������ʱ�ͷ��أ�����һֱ�ȴ��ڻ�ȡ���Ķ�����
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
            System.out.println(Thread.currentThread().getId() + "�߳��˳�");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
        //��ͨ������
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
        demo1.join();//���̵߳ȴ����߳�ִ������ִ��
        demo2.join();
        demo3.join();
        demo4.join();
        demo5.join();
        System.out.println(i);


        //��ʱ��
        ReentrantLockDemo demo6 = new ReentrantLockDemo("timelimitThread1",3);
        ReentrantLockDemo demo7 = new ReentrantLockDemo("timelimitThread2",3);
        demo6.start();
        demo7.start();
         **/
        //���� �жϲ���
        ReentrantLockDemo demo8 = new ReentrantLockDemo("lockInterrupt1" ,4);
        ReentrantLockDemo demo9 = new ReentrantLockDemo("lockInterrupt2" ,5);
        demo8.start();
        demo9.start();
        Thread.sleep(1000);
       // DeadlockChecker.check();
    }

    /**
     * �����������4/5�ụ����������⵽��ִ��interrupt�ж�
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
            //����Ϊ�ػ��߳�--Ҳ�ơ������̡߳�����û���û��߳̿ɷ���ʱ���Զ��뿪�����ȼ����ػ��̵߳����ȼ��Ƚϵͣ�����Ϊϵͳ�е�����������߳��ṩ����
            tt.setDaemon(true);
            tt.start();
        }
    }
}

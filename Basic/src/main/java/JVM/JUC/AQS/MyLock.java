package JVM.JUC.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description �̳�AQS���У�ʵ���Լ��Ķ�ռ��
 * @Author Heling
 * @Date 2019/8/27 19:45
 **/
public class MyLock implements Lock {
    Helper helper = new Helper();

    public void lock() {
        helper.acquire(1);
    }

    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1,unit.toNanos(time));
    }

    public void unlock() {
        helper.release(1);
    }

    public Condition newCondition() {
        return helper.newCondition();
    }

    private class Helper extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            //�����һ���߳̽������õ���������TRUE
            //����ڶ����߳̽���������FALSE���ò�����
            int state = getState();//�������0��ʾlock��1��ʾunlock
            if(state == 0){
                if(compareAndSetState(0,arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }
            return false;
           // return super.tryAcquire(arg);
        }

        @Override
        protected boolean tryRelease(int arg) {
            //���Ļ�ȡ���ͷ���Ҫ11��Ӧ����ô��������������̣߳�һ���ǵ�ǰ�߳��á�
            if(Thread.currentThread() != getExclusiveOwnerThread()){
                throw new RuntimeException();
            }
            int state = getState() - arg;
            setState(state);
            if(state == 0){
                setExclusiveOwnerThread(null);
                return true;
            }
            return false;
           // return super.tryRelease(arg);
        }

        Condition newCondition() {
            /** �ṩ���ڲ���ConditionObject,����ʵ��Condition�ӿڣ�����await/signal **/
            return new ConditionObject();
        }

    }
}

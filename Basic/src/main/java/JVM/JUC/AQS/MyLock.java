package JVM.JUC.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description 继承AQS队列，实现自己的独占锁
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
            //如果第一个线程进来，拿到锁，返回TRUE
            //如果第二个线程进来，返回FALSE，拿不到锁
            int state = getState();//获得锁，0表示lock，1表示unlock
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
            //锁的获取和释放需要11对应，那么调用这个方法的线程，一定是当前线程让。
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
            /** 提供的内部类ConditionObject,用于实现Condition接口，用于await/signal **/
            return new ConditionObject();
        }

    }
}

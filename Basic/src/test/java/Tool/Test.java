package Tool;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args)  {
        demoHowLockUse();
        testStringInstanceAndConstentDiff();
    }

    /**
     * 测试区分String对象和String常量，表明常量池的存在
     */
    public static void testStringInstanceAndConstentDiff(){
        String a = "A";     //常量池地址
        String a1= new String("A"); //堆对象地址
        String a2 = "A";    //常量池地址
        String b = new String("B"); //堆对象地址
        String c = "C";     //常量池地址
        String d = "A" + c;             //String对象拼接常量，按对象拼接方式，返回堆对象地址
        String e = "A" + "C";           //常量凭借常量，返回常量池地址
        System.out.println(d == e);             //FALSE d为堆地址;e为常量池地址
        System.out.println(a == a1);            //FALSE
        System.out.println(a == a1.intern());   //TRUE intern方法将a1的字符串放进常量池，返回常量池地址，指向同一个常量池对象
        System.out.println(a == a2);            //TRUE 都为常量池地址
    }

    /**
     * 测试Final修饰的String变量，被优化视为常量
     */
    public static void testFinalStringFieldIsConstent(){
        String a = "hello2";        //String常量池地址
        final String b = "hello";   //Final String
        String d = "hello";         //String常量池地址，d为String对象
        String c = b + 2;           //Final String + 常量String
        String e = d + 2;           //普通String + 常量String = e为String对象地址
        System.out.println((a == c));   //结果TRUE，表明Final String + 常量String = c常量池地址，FinalString被当做常量
        System.out.println((a == e));   //结果FALSE，为常量池地址，e为对象地址
    }

    /**
     * 验证Integer对象某些值范围的对象，有类似String常量池的整形常量池（严格来说只是Integer缓存，JVM启动的时候生成）。
     * Integer的缓存机制，某范围的Integer对象一个值只对应一个对象，
     * -XX:AutoBoxCacheMax=size可以改变缓存的值的范围
     */
    public static void testIntegerRangeInstanceWasPoolManaged(){
        //对于基本数据类型来说，==比较的就是指
        int i1 = 1;
        int i2 = 1999;
        int i3 = 2000;
        int i4 = i1 + i2;
        System.out.println(i3 == i4); //TRUE

        //封装数据对象，==比较的是地址
        Integer i5 = 1;
        Integer i6 = 1999;
        Integer i7 = 2000;
        Integer i8 = i5 + i6;
        Integer i9 = 2;
        Integer i10 = 3;
        Integer i11 = i5 + i9;
        System.out.println(i7 == i8);   //FALSE  对象内值相同，对象地址却不同
        System.out.println(i10 == i11); //TRUE  对于范围内的Integer值，值相同会使用同一个Integer对象缓存地址

    }

    /**
     * 验证finally语句的执行
     *  finally 语句块作为 subroutine直接插入到 try 语句块或者 catch 语句块之后（有控制转移语句要在语句之前）。
     *  所以只要进入了try，就一定会执行finally语句块
     */
    public static void testExceptionFinallyStatementExecution(){
        int i = testExceptionFinallyStatement_TryBlockReturn();
        System.out.println("返回值（1初始值；2finally++后的值）：" + i );
    }

    /**
     * 验证 finally语句，内对变量操作却没有改变
     * 解释：return 操作会将i的值缓存在本地变量表中，在执行finally，所以即使执行了i++，会恢复缓存，所以返回也是初始值1
     * 如果i变为一个没有常量池管理的对象，那么缓存的就是实例的地址，内部值仍可以改变
     * @return
     */
    public static int testExceptionFinallyStatement_TryBlockReturn(){
        int i = 1;
        try{
            return i;
        }catch (Exception ex){
        }finally {
            i++;
        }
        return i;
    }

    /**
     * 创建线程执行的三种方式：
     *      继承Thread重写run方法
     *      实现runnable run方法
     *      实现Callable call方法（带返回值）
     */
    public static void demoWaysToStartThread(){
        demoWaysToStartThread_ThreadClass();
        demoWaysToStartThread_RunnableInterface();
        try {
            demoWaysToStartThread_CallableInterface();
        }catch (ExecutionException ex ){

        }catch (InterruptedException ex ){

        }
    }

    /**
     * 创建线程执行的方式1:继承Thread类重写run方法，直接执行
     */
    public static void demoWaysToStartThread_ThreadClass(){
        Thread thread = new Thread(){
            public void run() {
                System.out.println("Thread.run()");
            }
        };
        thread.run();
    }

    /**
     * 创建线程执行的方式2：实现Callable的run方法，交给Thread执行
     * 优点：以接口的方式可以实现线程，避免影响继承关系
     */
    public static void demoWaysToStartThread_RunnableInterface(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable.run()");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    /**
     * 创建线程的执行的方式3：实现Callable的call方法，托管给Future执行Task
     * 优点：带有放回值的线程
     * @throws Exception
     */
    public static void demoWaysToStartThread_CallableInterface() throws ExecutionException, InterruptedException{
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("Callable.run()");
                return "Callable return String";
            }
        };
        //注释：FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建，它同时实现了Future和Runnable接口。
        FutureTask futureTask = new FutureTask(callable);
        //执行方式1： 直接交给Thread，使用runnable接口方式交给Thread执行
        Thread oneThread = new Thread(futureTask);
        oneThread.start();
        //执行方式2： 交给ExecutorService 线程池执行
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Future f = pool.submit(futureTask);
        pool.shutdown();
        System.out.println(">>>" + f.get().toString());
    }

    /**
     * 使用Lock锁的方式
     */
    public static void demoHowLockUse(){
        demoHowLockUse_ReentrantLock_Lock();
    }

    /**
     * ReentrantLock lock方式获得锁
     */
    public static void demoHowLockUse_ReentrantLock_Lock(){
         final ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        ArrayList<Thread> altThreads = new ArrayList();
        for (int i = 0; i <30 ; i++) {
            altThreads .add ( new Thread(new Runnable() {
                public void run() {
                    reentrantLockTest.lockTest(Thread.currentThread());
                }
            }, "Thread" + i ) );
        }
        for (int i = 0; i < altThreads.size(); i++) {
            altThreads.get(i).start();
        }
    }

    /**
     * ReentrantLock代表lock，演示如何使用Lock
     */
    public static class ReentrantLockTest {
        private Lock lock = new ReentrantLock();

        public Lock getLock() {
            return lock;
        }

        /**
         * tryLock设置尝试获得锁的等待时长
         * @param thread
         * @throws InterruptedException
         */
        public void tryLockParamTest(Thread thread) throws InterruptedException {
            if(lock.tryLock(3000, TimeUnit.MILLISECONDS)) { //尝试获取锁 获取不到锁，就等3秒，如果3秒后还是获取不到就返回false
                try {
                    System.out.println("线程"+thread.getName() + "获取当前锁"); //打印当前锁的名称
                    Thread.sleep(2000);//为看出执行效果，是线程此处休眠2秒
                } catch (Exception e) {
                    System.out.println("线程"+thread.getName() + "发生了异常释放锁");
                }finally {
                    System.out.println("线程"+thread.getName() + "执行完毕释放锁");
                    lock.unlock(); //释放锁
                }
            }else{
                System.out.println("我是线程"+Thread.currentThread().getName()+"当前锁被别人占用,等待3s后仍无法获取,放弃");
            }
        }

        /**
         *  tryLock 进行获得lock尝试
         *  尝试获取锁 tryLock() 它表示用来尝试获取锁，如果获取成功，则返回true，如果获取失败（即锁已被其他线程获取），则返回false
         */
        public void tryLockTest(Thread thread) {
            if(lock.tryLock()) { //尝试获取锁
                try {
                    System.out.println("线程"+thread.getName() + "获取当前锁"); //打印当前锁的名称
                    Thread.sleep(2000);//为看出执行效果，是线程此处休眠2秒
                } catch (Exception e) {
                    System.out.println("线程"+thread.getName() + "发生了异常释放锁");
                }finally {
                    System.out.println("线程"+thread.getName() + "执行完毕释放锁");
                    lock.unlock(); //释放锁
                }
            }else{
                System.out.println("我是线程"+Thread.currentThread().getName()+"当前锁被别人占用，我无法获取");
            }
        }

        /**
         * 直接lock unlock
         * 使用完毕释放后其他线程才能获取锁
         */
        public void lockTest(Thread thread) {
            lock.lock();//获取锁
            try {
                System.out.println("线程"+thread.getName() + "获取当前锁"); //打印当前锁的名称
                Thread.sleep(2000);//为看出执行效果，是线程此处休眠2秒
            } catch (Exception e) {
                System.out.println("线程"+thread.getName() + "发生了异常释放锁");
            }finally {
                System.out.println("线程"+thread.getName() + "执行完毕释放锁");
                lock.unlock(); //释放锁
            }
        }
    }

}
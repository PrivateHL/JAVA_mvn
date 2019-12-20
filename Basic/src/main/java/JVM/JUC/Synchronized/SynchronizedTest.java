package JVM.JUC.Synchronized;

/**
 * @Description: 代码块：使用monitorenter和monitorexit指令实现,查看class文件
 * @Author:  HeLing
 * @Date: 2019/8/28 12:37
 */
public class SynchronizedTest
{
    public synchronized void test1 (){
    }
    public void test2 (){
        synchronized ( this ){ }
    }
}
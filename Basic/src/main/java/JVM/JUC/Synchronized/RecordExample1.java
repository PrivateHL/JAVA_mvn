package JVM.JUC.Synchronized;

public class RecordExample1 implements Runnable{
    int a = 1;
    boolean flag = false;

    /**
     * A线程执行
     */
    public void writer(){
        a = 2;                  // 1
        flag = true;            // 2
    }

    /**
     * B线程执行
     */


    public void read(){
        while(flag){                  // 3
            //int i = a + a;          // 4
            System.out.println("a=" + a);
            break;
        }
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.print(threadName + " ");
        if(threadName.startsWith("w")){
            writer();
        }else{
            read();
        }
        //System.out.println("");
    }
    public static void main (String[] args){
        RecordExample1 rcd = new RecordExample1();
        Thread w = new Thread(rcd,"w");
        Thread r = new Thread(rcd,"r");
        w.start();
        r.start();
    }
}
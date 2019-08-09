package JVM;

//help->edit custom VM options 加入参数开启查看GC
//            -verbose:gc ： 开启gc日志
//            -XX:+PrintGCDetails ： 打印gc详情
//            -XX:+PrintGCDateStamps ： 打印gc时间戳
//            -Xloggc:gcc.log ： 将日志输出到文件xx(默认位置为桌面)

public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] BigSize = new byte[2 * _1MB];


    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        System.gc();
    }
}

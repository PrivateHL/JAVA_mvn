package JVM.GC;

public class MinorGC {
    private static final int _1MB = 1024 * 1024;

    public static void main (String[] agrs){
        testPretenureSizeThreshold();
    }

    /**
     * 实验年轻GC
     *
     * vm参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:survivorRatio=8
     */
    public static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//出现一次minor GC
    }

    /**
     * 实验大对象直接进入老年区
     * vm参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:survivorRatio=8
     *          -XX:PretenureSizeThreshold=3145728
     * PretenureSizeThreshold参数值不能带单位 需要转化为byte,参数只对Serial/ParNew两款收集器有效
     */
    public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[ 4 * _1MB];//直接分配到老年代
    }

    /**
     * 实验长期存活的对象将进入老年代  到达年龄就会进入老年代
     * vm参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:survivorRatio=8
     *          -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=1
     * PretenureSizeThreshold参数值不能带单位 需要转化为byte,参数只对Serial/ParNew两款收集器有效
     */
    public  static void testTenuingThreshold(){
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[ _1MB/ 4 ];
        allocation2 = new byte[ 4 * _1MB];
        allocation3 = new byte[ 4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[ 4 * _1MB];
    }

    /**
     * 实验长期存活的对象将进入老年代  相同年龄所有对象大小总和大于存活区内存的一半，则大于等于这个年龄的对象都可以搬家去养老区
     * vm参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:survivorRatio=8
     *          -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=15
     * PretenureSizeThreshold参数值不能带单位 需要转化为byte,参数只对Serial/ParNew两款收集器有效
     */
    public  static void testTenuingThreshold2(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[ _1MB/ 4 ];
        allocation2 = new byte[ _1MB/ 4 ];
        //allocation1 + allocation2的大小为0.5MB为存活区的一半
        allocation3 = new byte[ 4 * _1MB];
        allocation4 = new byte[ 4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[ 4 * _1MB];
    }

    /**
     * 实验空间分配担保
     * vm参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:survivorRatio=8
     *          -XX:HandlePromotionFailure
     * HandlePromotionFailure 参数设置在JDK 1.6 update 24后就不会再生效
     */
    public static void testHandlePromotion(){
        byte[] allocation1,allocation2,allocation3,allocation4,allocation5,allocation6,allocation7;
        allocation1 = new byte[ 2 * _1MB];
        allocation2 = new byte[ 2 * _1MB];
        allocation3 = new byte[ 2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[ 2 * _1MB];
        allocation5 = new byte[ 2 * _1MB];
        allocation6 = new byte[ 2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }
}

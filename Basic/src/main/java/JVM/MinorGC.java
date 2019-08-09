package JVM;

public class MinorGC {
    private static final int _1MB = 1024 * 1024;

    public static void main (String[] agrs){
        testPretenureSizeThreshold();
    }

    /**
     * ʵ������GC
     *
     * vm���� -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:survivorRatio=8
     */
    public static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//����һ��minor GC
    }

    /**
     * ʵ������ֱ�ӽ���������
     * vm���� -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:survivorRatio=8
     *          -XX:PretenureSizeThreshold=3145728
     * PretenureSizeThreshold����ֵ���ܴ���λ ��Ҫת��Ϊbyte,����ֻ��Serial/ParNew�����ռ�����Ч
     */
    public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[ 4 * _1MB];//ֱ�ӷ��䵽�����
    }

    /**
     * ʵ�鳤�ڴ��Ķ��󽫽��������  ��������ͻ���������
     * vm���� -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:survivorRatio=8
     *          -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=1
     * PretenureSizeThreshold����ֵ���ܴ���λ ��Ҫת��Ϊbyte,����ֻ��Serial/ParNew�����ռ�����Ч
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
     * ʵ�鳤�ڴ��Ķ��󽫽��������  ��ͬ�������ж����С�ܺʹ��ڴ�����ڴ��һ�룬����ڵ����������Ķ��󶼿��԰��ȥ������
     * vm���� -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:survivorRatio=8
     *          -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=15
     * PretenureSizeThreshold����ֵ���ܴ���λ ��Ҫת��Ϊbyte,����ֻ��Serial/ParNew�����ռ�����Ч
     */
    public  static void testTenuingThreshold2(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[ _1MB/ 4 ];
        allocation2 = new byte[ _1MB/ 4 ];
        //allocation1 + allocation2�Ĵ�СΪ0.5MBΪ�������һ��
        allocation3 = new byte[ 4 * _1MB];
        allocation4 = new byte[ 4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[ 4 * _1MB];
    }

    /**
     * ʵ��ռ���䵣��
     * vm���� -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:survivorRatio=8
     *          -XX:HandlePromotionFailure
     * HandlePromotionFailure ����������JDK 1.6 update 24��Ͳ�������Ч
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

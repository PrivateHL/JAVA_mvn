package JVM;

//help->edit custom VM options ������������鿴GC
//            -verbose:gc �� ����gc��־
//            -XX:+PrintGCDetails �� ��ӡgc����
//            -XX:+PrintGCDateStamps �� ��ӡgcʱ���
//            -Xloggc:gcc.log �� ����־������ļ�xx(Ĭ��λ��Ϊ����)

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

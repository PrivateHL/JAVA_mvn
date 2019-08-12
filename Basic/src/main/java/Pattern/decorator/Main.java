package Pattern.decorator;

/**
 * @Description װ��ģʽ��Ҫ�������½�ɫ��
 * *     ���󹹼���Component����ɫ������һ������ӿ��Թ淶׼�����ո������εĶ���
 * *     ���幹����Concrete    Component����ɫ��ʵ�ֳ��󹹼���ͨ��װ�ν�ɫΪ�����һЩְ��
 * *     ����װ�Σ�Decorator����ɫ���̳г��󹹼������������幹����ʵ��������ͨ����������չ���幹���Ĺ��ܡ�
 * *     ����װ�Σ�ConcreteDecorator����ɫ��ʵ�ֳ���װ�ε���ط������������幹��������Ӹ��ӵ����Ρ�
 * @Author Heling
 * @Date 2019/8/12 11:17
 **/
public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello world");
        Display b2 = new SideBorder(b1, '#');//���ұ߿��helloWorld
        Display b3 = new FullBorder(b2);//���ұ߿��helloworld �����������ұ߿�
        b1.show();
        b2.show();
        b3.show();
        Display b4 =
                new SideBorder(
                     new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("��ã�����װ��ģʽ")
                                        )
                                        ,'*'
                                )
                        )
                    ),'/'
             );
        b4.show();

        Display b5 =
                new SideBorder(
                        new FullBorder (
                                new  UpDownBorder(
                                        new SideBorder(
                                                new UpDownBorder(
                                                        new StringDisplay("��ã�����װ��ģʽ"),'#'
                                                )
                                                ,'*'
                                        ),'='
                                )
                        ),'/'
                );
        b5.show();

        MultiStringDisplay md = new MultiStringDisplay();
        md.add("���Ϻã�");
        md.add("�����Ϻã�");
        md.add("�����������");
        Display d6 = new SideBorder(md,'#');
        d6.show();
        Display d7 = new FullBorder(md);
        d7.show();
    }
}

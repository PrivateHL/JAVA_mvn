package Pattern.decorator;

/**
 * @Description 装饰模式主要包含以下角色。
 * *     抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
 * *     具体构件（Concrete    Component）角色：实现抽象构件，通过装饰角色为其添加一些职责。
 * *     抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * *     具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 * @Author Heling
 * @Date 2019/8/12 11:17
 **/
public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello world");
        Display b2 = new SideBorder(b1, '#');//左右边框的helloWorld
        Display b3 = new FullBorder(b2);//左右边框的helloworld 加上上下左右边框
        b1.show();
        b2.show();
        b3.show();
        Display b4 =
                new SideBorder(
                     new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("你好，这是装饰模式")
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
                                                        new StringDisplay("你好，这是装饰模式"),'#'
                                                )
                                                ,'*'
                                        ),'='
                                )
                        ),'/'
                );
        b5.show();

        MultiStringDisplay md = new MultiStringDisplay();
        md.add("早上好，");
        md.add("下午上好，");
        md.add("晚安，明天见。");
        Display d6 = new SideBorder(md,'#');
        d6.show();
        Display d7 = new FullBorder(md);
        d7.show();
    }
}

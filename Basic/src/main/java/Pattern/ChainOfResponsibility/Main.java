package Pattern.ChainOfResponsibility;

/**
 * @Description ������ģʽ ��ж����ģʽ������������һ��ְ����������˳���ҳ��������˭����
 * @Author Heling
 * @Date 2019/8/14 10:58
 **/
public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob",100);
        Support charlie = new SpecialSupport("charlie",429);
        Support diana = new LimitSupport("diana",200);
        Support elmo = new OddSupport("elmo");
        Support fred = new LimitSupport("fred",300);

        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for (int i = 0; i <500 ; i+=33) {
            alice.support(new Trouble(i));
        }
    }
}

package Pattern.Memento;

/**
 * @Description ����������ʲôʱ�����ɼ���Ʒʲôʱ��ָ�����Ʒ����������Ʒ���ݸ������ߣ�����+�н�
 * @Author Heling
 * @Date 2019/8/16 13:06
 **/
public class Main {
    public static void main(String[] args) {

        Gamer gamer = new Gamer(100);
        Memento memento = gamer.creatrMemento();
        for (int i = 0; i <100 ; i++) {
            System.out.println("=====" + i);
            System.out.println("��ǰ״̬ " + gamer);

            gamer.bet();

            System.out.println("�����" + gamer.getMoney());
            if(gamer.getMoney() > memento.getMoney()){
                System.out.println(" ��Ǯ���� ����״̬");
            }else if (gamer.getMoney() < memento.getMoney() /2){
                System.out.println("��Ǯ���� �ָ�״̬");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }
}

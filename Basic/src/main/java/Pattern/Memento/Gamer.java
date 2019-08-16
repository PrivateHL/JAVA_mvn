package Pattern.Memento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @Description ����Ʒ������ �ṩ�ӿڸ��ݼ���Ʒ�ָ�ʵ��״̬
 * @Author Heling
 * @Date 2019/8/16 13:05
 **/
public class Gamer {
    private int money;
    private List fruits = new ArrayList();
    private Random random = new Random();
    private  static String[] fuitsname ={
            "ƻ��","����","�㽶","����"
    };

    public Gamer(int money) {
        this.money = money;
    }
    public int getMoney(){
        return money;
    }
    public void bet(){
        int dice = random.nextInt(6) + 1;
        if(dice == 1){
            money += 100;
            System.out.println("����Ǯ100.");
        }else if (dice == 2){
            money /= 2;
            System.out.println("Ǯ����");
        }else if (dice == 6){
            String f = getFruit();
            System.out.println("�����ˮ��"+f );
            fruits.add(f);
        }else{
            System.out.println("��");
        }
    }


    public Memento creatrMemento(){
        Memento m = new Memento(money);
        Iterator it = fruits.iterator();
        while(it.hasNext()){
            String f = (String) it.next();
            if (f.startsWith("�óԵ�")) {
                m.addFruit(f);
            }
        }
        return m;
    }
    public void restoreMemento(Memento memento){
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }
    private String getFruit(){
        String prefix = "";
        if(random.nextBoolean()){
            prefix = "�óԵ�";
        }
        return prefix + fuitsname[random.nextInt(fuitsname.length)];
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }
}

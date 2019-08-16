package Pattern.Memento;

/**
 * @Description 控制生成者什么时候生成纪念品什么时候恢复纪念品，并将纪念品传递给生成者，控制+中介
 * @Author Heling
 * @Date 2019/8/16 13:06
 **/
public class Main {
    public static void main(String[] args) {

        Gamer gamer = new Gamer(100);
        Memento memento = gamer.creatrMemento();
        for (int i = 0; i <100 ; i++) {
            System.out.println("=====" + i);
            System.out.println("当前状态 " + gamer);

            gamer.bet();

            System.out.println("结果：" + gamer.getMoney());
            if(gamer.getMoney() > memento.getMoney()){
                System.out.println(" 金钱增多 保存状态");
            }else if (gamer.getMoney() < memento.getMoney() /2){
                System.out.println("金钱减半 恢复状态");
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

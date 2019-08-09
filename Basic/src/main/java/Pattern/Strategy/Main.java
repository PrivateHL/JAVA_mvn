package Pattern.Strategy;

/**
 * @Description 策略模式 两个策略对抗
 * @Author Heling
 * @Date 2019/8/9 13:50
 **/
public class Main {
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("Uage: java main randomseed1 randomseec2");
            System.out.println("Example: java main 314 15");
            System.exit(0);
        }
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);
        Player player1 = new Player("AA",new WnningStrategy(seed1));
        Player player2 = new Player("CC",new ProbStrategy(seed2));
        Player player3 = new Player("RR",new RandomStrategy(seed2));

        FightVS(player1,player2,10000);
        player1.clean();
        player2.clean();
        FightVS(player1,player3,10000);
    }

    private static void FightVS(Player p1, Player p2, int round){
        for (int i = 0; i <round ; i++) {
            Hand nextHand1 = p1.nextHand();
            Hand nextHand2 = p2.nextHand();
            if(nextHand1.fight(nextHand2) == 0){
//                System.out.println("Eve...");
                p1.even();
                p2.even();
            }else if(nextHand1.fight(nextHand2) > 0){
//                System.out.println("Winner:" + p1);
                p1.win();
                p2.lose();
            }else{
//                System.out.println("Winner:" + p2);
                p1.lose();
                p2.win();
            }
        }
        System.out.println("total result:");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}

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
        for (int i = 0; i <10000 ; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if(nextHand1.fight(nextHand2) == 0){
                System.out.println("Eve...");
                player1.even();
                player2.even();
            }else if(nextHand1.fight(nextHand2) > 0){
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            }else{
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            }
        }
        System.out.println("total result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}

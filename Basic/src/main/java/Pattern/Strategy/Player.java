package Pattern.Strategy;

public class Player {
    private String name;
    private  Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }
    public Hand nextHand(){
        return strategy.nextHand();
    }
    public void win(){
        strategy.study(true);
        wincount ++;
        gamecount ++;
    }
    public void lose(){
        strategy.study(false);
        losecount++;
        gamecount++;
    }
    public void even(){
        gamecount++;
    }

    public void clean(){
        wincount = 0;
        losecount = 0;
        gamecount = 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", strategy=" + strategy +
                ", wincount=" + wincount +
                ", losecount=" + losecount +
                ", gamecount=" + gamecount +
                '}';
    }
}

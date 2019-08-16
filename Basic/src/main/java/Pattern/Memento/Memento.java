package Pattern.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 纪念品 保存内部的信息集合
 * @Author Heling
 * @Date 2019/8/16 13:00
 **/
public class Memento {
    int money;
    ArrayList fruits;
    public int getMoney(){
        return money;
    }
    Memento (int money){
        this.money = money;
        this.fruits = new ArrayList();
    }

    void addFruit(String fruit){
        fruits.add(fruit);
    }
    List getFruits(){
        return (List) fruits.clone();
    }
}

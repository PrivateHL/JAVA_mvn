package Pattern.Observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description 生成数值的抽象类 抽象的观察对象
 * @Author Heling
 * @Date 2019/8/16 11:34
 **/
public abstract class NumberGenerator {
    private ArrayList observers = new ArrayList();
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void deleteObserver(Observer observer){
        observers.remove(observer);
    }
    public  void notifyObservers(){
        Iterator it = observers.iterator();
        while(it.hasNext()){
            Observer o = (Observer) it.next();
            o.update(this);
        }
    }
    public abstract int getNumber();
    public abstract void execute();

}

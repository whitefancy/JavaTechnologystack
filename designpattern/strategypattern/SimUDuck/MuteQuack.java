package designpattern.strategypattern.SimUDuck;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        //什么也不做，不会叫
    }
}

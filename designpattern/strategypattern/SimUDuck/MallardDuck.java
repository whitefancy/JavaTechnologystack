package designpattern.strategypattern.SimUDuck;

public class MallardDuck extends Duck {
    //绿头鸭
    public MallardDuck(){
        flyBehavior=new FlyWithWings();
        quackBehavior=new Quack();
    }
    @Override
    void display() {
        System.out.println("绿头绿头，原谅色鸭子！");
    }
}

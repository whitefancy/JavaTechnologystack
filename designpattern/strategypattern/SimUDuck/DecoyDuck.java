package designpattern.strategypattern.SimUDuck;

public class DecoyDuck extends Duck{
    //诱饵鸭
    public  DecoyDuck(){
        flyBehavior=new FlyNoWay();
        quackBehavior=new MuteQuack();
    }

    @Override
    void display() {
        System.out.println("我是诱饵鸭，不说话，很诱人！");
    }

}

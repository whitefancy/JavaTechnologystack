package designpattern.strategypattern.SimUDuck;

public class RedheadDuck extends Duck {
    //红头鸭
    public RedheadDuck()
    {
        flyBehavior=new FlyWithWings();
        quackBehavior=new Quack();
    }
    @Override
    void display() {
        System.out.println("红头尖头，公鸡似我~");
    }
}

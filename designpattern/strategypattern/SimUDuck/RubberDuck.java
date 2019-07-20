package designpattern.strategypattern.SimUDuck;

public class RubberDuck extends Duck{
    //橡皮鸭
    public RubberDuck(){
        flyBehavior=new FlyNoWay();
        quackBehavior=new Squeak();
    }

    @Override
    void display() {
        System.out.println("橡皮鸭！眼睛不会眨！");
    }
}

package designpattern.adapterpattern.darkturkey;


public class MallardDuck implements Duck {
    //绿头鸭
    MallardDuck() {
    }

    @Override
    public void fly() {
        System.out.println("I am flying~");
    }

    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}

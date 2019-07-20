package designpattern.strategypattern.SimUDuck;

public class DuckCall{
    //鸭鸣器
    QuackBehavior quackBehavior;
    public DuckCall()
    {
        quackBehavior = new Quack();
        quackBehavior.quack();
    }
}

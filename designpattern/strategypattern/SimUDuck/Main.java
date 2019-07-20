package designpattern.strategypattern.SimUDuck;

public class Main {
    public static void main(String[] args)
    {
        test(new MallardDuck());
        test(new RedheadDuck());
        test(new RubberDuck());
        test(new DecoyDuck());
        DuckCall duckCall = new DuckCall();

    }
    static void test(Duck duck1)
    {
        duck1.showTime();
    }
}

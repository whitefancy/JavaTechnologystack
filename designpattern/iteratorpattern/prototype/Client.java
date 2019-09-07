package designpattern.iteratorpattern.prototype;

public class Client {
    {
        Aggregate aggregate = new ConcreteAggregate();
        Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
        }
    }
}

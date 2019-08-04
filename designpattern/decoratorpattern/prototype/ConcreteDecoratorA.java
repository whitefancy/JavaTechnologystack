package designpattern.decoratorpattern.prototype;

/**
 * ConcreteDecorator 有一个实例变量，可以记录所装饰的事物
 * 装饰者包着Companent
 */
public class ConcreteDecoratorA extends Decorator {
    Component wrappedObj;

    @Override
    void methodA() {
        super.methodA();
    }

    @Override
    void methodB() {
        super.methodB();
    }

    void newBehavior() {

    }
}

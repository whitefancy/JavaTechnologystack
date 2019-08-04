package designpattern.decoratorpattern.prototype;

/**
 * 动态加上新行为的对象
 */
public class ConcreteComponent extends Component {
    @Override
    void methodA() {
        super.methodA();
    }

    @Override
    void methodB() {
        super.methodB();
    }
}

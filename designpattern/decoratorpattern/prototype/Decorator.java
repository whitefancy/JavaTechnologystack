package designpattern.decoratorpattern.prototype;

/**
 * 每个装饰者（包装一个）组件，装饰者有一个实例变量保存某个Component的引用
 */
class Decorator extends Component {
    @Override
    void methodA() {
        super.methodA();
    }

    @Override
    void methodB() {
        super.methodB();
    }
}

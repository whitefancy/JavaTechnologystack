package designpattern.templatemethodpattern.prototype;

/**
 * 抽象类，算法模版
 */
public abstract class AbstractClass {
    void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }

    /**
     * 这个具体的方法，什么都不做。
     * 默认不做事的方法，称为hook（钩子）
     * 子类可以视情况要不要覆盖它们
     * 钩子的存在，可以让子类有能力对算法的不同点进行挂钩
     */
    private void hook() {
    }

    private void concreteOperation() {
        //算法保护的实现
    }

    protected abstract void primitiveOperation2();

    protected abstract void primitiveOperation1();
}

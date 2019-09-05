package designpattern.adapterpattern.darkturkey;

/**
 * 首先，你需要实现想要转换成的接口的方法。比如想要转换成鸭子接口
 */
public class TurkeyAdapter implements Duck {
    private Turkey turkey;

    /*
    然后对当前拥有的接口进行包装。比如拥有火鸡接口
     */
    TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void fly() {
        turkey.gobble();
    }

    @Override
    public void quack() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}

package designpattern.adapterpattern.darkturkey;

/**
 * 让一个适配器包装一个被适配者，称为适配器模式
 * 让一个适配器包装多个被适配者，称为外观模式
 * 双向适配器，同时实现新，旧两个接口，而不仅仅是新接口。
 */
public class DuckAdapter implements Turkey {
    private Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        System.out.println("I am flying a short distance");
    }
}

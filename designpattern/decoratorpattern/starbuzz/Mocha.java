package designpattern.decoratorpattern.starbuzz;

/**
 * CondimentDecorator扩展自Beverage
 * 用一个 实例变量记录饮料，也就是被装饰者。
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    /**
     * 想办法让被装饰者（饮料）被记录到实例变量中，比如使用构造器记录
     *
     * @param beverage
     */
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * 我们希望叙述不光描述饮料，而是完整低连调料也描述
     * 首先利用委托的方法，得到一个叙述，然后在其后加上附加的叙述
     *
     * @return
     */
    @Override
    public String getDiscription() {
        return beverage.getDiscription() + ", Mocha";
    }

    /**
     * 计算Mocha饮料的钱，首先把调用委托给被装饰对象，以计算价钱，然后加上Mocha的价钱，得到结果
     *
     * @return
     */
    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}

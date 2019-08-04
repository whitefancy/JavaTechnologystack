package designpattern.decoratorpattern.starbuzz;

/**
 * 调料装饰器
 * 必须能取代Beverage，所以要扩展自Beverage
 */
public abstract class CondimentDecorator extends Beverage {
    /*
    所有的调料装饰者必须重新实现getDescription方法
     */
    @Override
    public abstract String getDiscription();
}

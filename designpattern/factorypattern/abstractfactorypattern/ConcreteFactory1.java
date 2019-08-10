package designpattern.factorypattern.abstractfactorypattern;

/**
 * 工厂方法潜伏在抽象工厂里
 * 抽象工厂的方法经常以工厂方法的方式实现
 * 区别
 * 工厂方法使用的是类         抽象工厂使用的是对象
 * 工厂方法创建对象需要通过继承扩展一个类    抽象工厂是通过对象的组合
 * 工厂方法实质是通过子类创建对象           抽象工厂把一群相关的产品集合起来
 * 抽象工厂，新增产品，必须改变接口
 * 共同点 使应用程序解耦，降低其对特定实现的依赖
 * <p>
 * 当需要创建产品家族，和想让制造的相关产品集合起来，可以使用抽象工厂
 * <p>
 * 目前还不知道将来要实例化哪些具体类 或需要解耦 使用工厂方法
 */
public class ConcreteFactory1 implements AbstractFactory {

    @Override
    public AbstractProductA CreateProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB CreateProductB() {
        return new ProductB1();
    }
}

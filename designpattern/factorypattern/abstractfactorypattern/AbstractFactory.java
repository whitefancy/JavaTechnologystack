package designpattern.factorypattern.abstractfactorypattern;

/**
 * 客户代码只需涉及抽象工厂，运行时将自动使用实际的工厂
 * 包含一组生产产品的抽象方法
 */
public interface AbstractFactory {
    public abstract AbstractProductA CreateProductA();

    public abstract AbstractProductB CreateProductB();
}

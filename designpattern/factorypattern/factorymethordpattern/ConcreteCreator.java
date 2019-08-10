package designpattern.factorypattern.factorymethordpattern;

/**
 * 负责创建一个或多个具体产品 只有具体的creator知道如何创建这些产品
 * <p>
 * 即使只有一个具体创建者，工厂方法模式依然有用，它帮助我们解耦产品的实现和使用
 * 无论创建如何变化，使用者 父类creator都不会受影响
 * <p>
 * 工厂方法和创建者并不总是抽象的，也可以有个默认的构造方法，即使没有子类，也能创建产品
 * 工厂经常只产生一种对象，不需要参数化，但也可以有参数化工厂。
 * <p>
 * 简单工厂->工厂方法 前者是封装，后者更有弹性
 * 这样可以帮助我们针对接口编程 而不是针对实现编程
 * 即 依赖倒置原则（DIP）：要依赖抽象（类、接口），而不是具体类
 * 应用工厂方法后，高层组件Pizzastore 和底层组件具体pizza 都依赖Pizza抽象 即产品抽象
 * <p>
 * 先想一个pizza抽象，然后知道它需要生产，分类等
 * <p>
 * 依赖倒置原则的指导方针
 * 变量不可以持有具体类的引用
 * 不要让类派生自具体类
 * 不要覆盖基类中 已经实现的方法
 * <p>
 * 如果一个类可以改变，就该用依赖倒置原则
 */
public class ConcreteCreator extends Creator {
    @Override
    public void factoryMethod() {

    }
}

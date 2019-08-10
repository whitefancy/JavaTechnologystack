package designpattern.factorypattern.pizzashop.ingredient.ingredientfactory;

import designpattern.factorypattern.pizzashop.ingredient.*;

/**
 * 配料工厂 番茄酱等
 * <p>
 * 把所有的工厂类放在同一个包里，最外面的包，这样他们之间的方法调用就是包内的，别的类就不能随便调用了。
 * <p>
 * 抽象工厂模式：提供一个接口， 用于创建相关或依赖对象的家族，而不需要指明具体类
 * 特点 不需要关心具体产出是什么
 */
public interface PizzaIngredientFactory {
    /*
    在接口中，每个原料都有一个对应的方法创建该原料
    如果每个工厂实例都有通用的实现，可以把这个工厂改写成抽象类
     */
    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams creatClam();
}

package designpattern.factorypattern.pizzashop;

import designpattern.factorypattern.pizzashop.pizza.Pizza;
import designpattern.factorypattern.pizzashop.pizzastore.ChicagoPizzaStore;
import designpattern.factorypattern.pizzashop.pizzastore.PizzaStore;

/**
 * 所有工厂模式都用来封装对象的创建
 * 工厂方法模式 分为 创建者类 store 和 产品类pizza
 * 工厂方法 将生产知识 封装进 各个创建者 这可以视为一个框架
 * 产品类 和 创建者类 层级是平行的， 因为他们各自都有抽象类，二抽象类都有很多具体的子类 每个子类都有自己特定的实现
 * <p>
 * 工厂方法模式 定义
 */
public class PizzaTestDrive {
    public static void main(String[] args) {

        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("veggie");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }

}

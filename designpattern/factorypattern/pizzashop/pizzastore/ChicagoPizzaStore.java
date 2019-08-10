package designpattern.factorypattern.pizzashop.pizzastore;

import designpattern.factorypattern.pizzashop.SimplePizzaFactory;
import designpattern.factorypattern.pizzashop.ingredient.ingredientfactory.PizzaIngredientFactory;
import designpattern.factorypattern.pizzashop.ingredient.ingredientfactory.impl.ChicagoPizzaIngredientFactory;
import designpattern.factorypattern.pizzashop.pizza.CheesePizza;
import designpattern.factorypattern.pizzashop.pizza.ClamPizza;
import designpattern.factorypattern.pizzashop.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    /**
     * 继承自PizzaStore的连锁店，可以使用自定义的Pizza生产方式，也可以使用工厂类的方法
     *
     * @param type
     * @return
     */
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Deep Dish Cheese Pizza");
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoPepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
        } else if (type.equals("veggie")) {
            pizza = new SimplePizzaFactory().createPizza(type);
        }
        return pizza;
    }


    private class ChicagoClamPizza extends Pizza {
    }

    private class ChicagoPepperoniPizza extends Pizza {
    }
}

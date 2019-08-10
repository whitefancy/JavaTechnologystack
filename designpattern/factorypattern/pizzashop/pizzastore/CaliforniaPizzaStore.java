package designpattern.factorypattern.pizzashop.pizzastore;

import designpattern.factorypattern.pizzashop.SimplePizzaFactory;
import designpattern.factorypattern.pizzashop.pizza.Pizza;

public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        return new SimplePizzaFactory().createPizza(type);
    }
}

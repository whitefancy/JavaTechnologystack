package designpattern.factorypattern.pizzashop.pizzastore;

import designpattern.factorypattern.pizzashop.SimplePizzaFactory;
import designpattern.factorypattern.pizzashop.ingredient.ingredientfactory.PizzaIngredientFactory;
import designpattern.factorypattern.pizzashop.ingredient.ingredientfactory.impl.NYPizzaIngredientFactory;
import designpattern.factorypattern.pizzashop.pizza.CheesePizza;
import designpattern.factorypattern.pizzashop.pizza.ClamPizza;
import designpattern.factorypattern.pizzashop.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (item.equals("pepperoni")) {
            pizza = new SimplePizzaFactory().createPizza(item);
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
        } else if (item.equals("veggie")) {
            pizza = new SimplePizzaFactory().createPizza(item);
        }
        return pizza;
    }
}

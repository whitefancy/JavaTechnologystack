package designpattern.factorypattern.pizzashop;

public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        return new SimplePizzaFactory().createPizza(type);
    }
}

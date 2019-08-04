package designpattern.factorypattern.pizzashop;

public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        return new SimplePizzaFactory().createPizza(type);
    }
}

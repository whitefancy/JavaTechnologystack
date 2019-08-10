package designpattern.factorypattern.pizzashop.pizza;

import designpattern.factorypattern.pizzashop.ingredient.ingredientfactory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        dough = ingredientFactory.createDough();
        sause = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.creatClam();
        super.prepare();
    }
}

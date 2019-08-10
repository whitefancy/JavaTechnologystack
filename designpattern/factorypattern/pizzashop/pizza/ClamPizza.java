package designpattern.factorypattern.pizzashop.pizza;

import designpattern.factorypattern.pizzashop.ingredient.ingredientfactory.PizzaIngredientFactory;

public class ClamPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
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

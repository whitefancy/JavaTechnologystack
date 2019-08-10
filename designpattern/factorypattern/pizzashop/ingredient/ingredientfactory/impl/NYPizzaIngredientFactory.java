package designpattern.factorypattern.pizzashop.ingredient.ingredientfactory.impl;

import designpattern.factorypattern.pizzashop.ingredient.*;
import designpattern.factorypattern.pizzashop.ingredient.impl.*;
import designpattern.factorypattern.pizzashop.ingredient.ingredientfactory.PizzaIngredientFactory;
import designpattern.factorypattern.pizzashop.ingredient.veggies.Garlic;
import designpattern.factorypattern.pizzashop.ingredient.veggies.Mushroom;
import designpattern.factorypattern.pizzashop.ingredient.veggies.Onion;
import designpattern.factorypattern.pizzashop.ingredient.veggies.RedPepper;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return new Veggies[0];
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams creatClam() {
        return new FreshClams();
    }
}

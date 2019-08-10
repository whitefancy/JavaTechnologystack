package designpattern.factorypattern.pizzashop.ingredient.ingredientfactory.impl;

import designpattern.factorypattern.pizzashop.ingredient.*;
import designpattern.factorypattern.pizzashop.ingredient.impl.*;
import designpattern.factorypattern.pizzashop.ingredient.ingredientfactory.PizzaIngredientFactory;
import designpattern.factorypattern.pizzashop.ingredient.veggies.BlackOlives;
import designpattern.factorypattern.pizzashop.ingredient.veggies.EggPlant;
import designpattern.factorypattern.pizzashop.ingredient.veggies.Spinach;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new BlackOlives(), new EggPlant(), new Spinach()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams creatClam() {
        return new FrozenClams();
    }
}

package designpattern.factorypattern.pizzashop.pizza;

import designpattern.factorypattern.pizzashop.ingredient.*;

import java.util.Arrays;

public abstract class Pizza {
    protected String name;
    Dough dough;
    Sauce sause;
    Cheese cheese;
    Clams clam;
    private Pepperoni pepperoni;
    private Veggies veggies[];

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void prepare() {
        System.out.println("prepareing " + name);
        System.out.println("Tossing dough..." + dough);
        System.out.println("Adding sauce..." + sause);
        System.out.println("Adding toppings:");
        for (int i = 0; i < veggies.length; i++) {
            System.out.println("    " + veggies[i]);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sause='" + sause + '\'' +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clam=" + clam +
                ", name='" + name + '\'' +
                '}';
    }
}

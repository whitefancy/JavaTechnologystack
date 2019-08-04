package designpattern.factorypattern.pizzashop;

import java.util.ArrayList;

abstract class Pizza {
    ArrayList toppings = new ArrayList<>();
    String dough;
    String sause;
    String name;

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void prepare() {
        System.out.println("prepareing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println("    " + toppings.get(i));
        }
    }

    String getName() {
        return name;
    }
}

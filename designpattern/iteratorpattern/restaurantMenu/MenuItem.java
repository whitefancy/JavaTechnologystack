package designpattern.iteratorpattern.restaurantMenu;

public class MenuItem {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    double getPrice() {
        return price;
    }
}

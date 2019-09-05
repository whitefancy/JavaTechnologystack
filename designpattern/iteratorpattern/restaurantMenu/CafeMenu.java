package designpattern.iteratorpattern.restaurantMenu;

import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu implements Menu {
    private Hashtable menuItems = new Hashtable();

    CafeMenu() {
        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false, 3.29);
        addItem("Burrito",
                "A large burrito ,with whole printo beans,salsa,guacamole",
                true, 4.29);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    @Deprecated
    public Hashtable getItems() {
        return menuItems;
    }

    /**
     * 这里使用了values（）而不是EntrySet(),变成了值组成的集合。
     *
     * @return
     */
    @Override
    public Iterator createIterator() {
        return menuItems.values().iterator();
    }
}

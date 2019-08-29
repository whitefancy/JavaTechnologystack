package designpattern.iteratorandcombinationpattern.iteratorpattern;

import java.util.Iterator;

class DinerMenu implements Menu {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private MenuItem[] menuItems;

    DinerMenu() {
        menuItems = new MenuItem[DinerMenu.MAX_ITEMS];
        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettue & tomato on whole wheat",
                true, 2.99);
        addItem("BLT",
                " Bacon with lettue & tomato on whole wheat",
                false, 2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false, 3.29);
        addItem("Hotdog",
                "A hot dog with saurkraut, relish,onions,topped with cheese",
                false, 3.05);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= DinerMenu.MAX_ITEMS) {
            System.out.println("Sorry, menu if full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

    /*
    我们不再需要这个方法，事实上，我们根本不想要这个方法，因为它会暴露我们的内部实现
        public MenuItem[] getMenuItems() {
            return menuItems;
        }
    */
    @Override
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}

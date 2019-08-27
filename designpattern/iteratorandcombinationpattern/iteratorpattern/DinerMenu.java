package designpattern.iteratorandcombinationpattern.iteratorpattern;

public class DinerMenu {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[DinerMenu.MAX_ITEMS];
        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettue & tomato on whole wheat",
                true, 2.99);
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
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}

package designpattern.compositepattern.restaurantMenu;

public class MenuTestDrive {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu =
                new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinnerMenu =
                new Menu("DINNER MENU", "Lunch");
        MenuComponent cafeMenu =
                new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu =
                new Menu("DESSERT MENU", "Dessert of course!");
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinnerMenu);
        allMenus.add(cafeMenu);
        dinnerMenu.add(new MenuItem("BLT",
                " Bacon with lettue & tomato on whole wheat",
                false, 2.99));
        dinnerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem(
                "Apple Pie",
                "Apple pie with flakey crust,topped with vanilla ice cream",
                true, 1.59));
        pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs,sausage",
                false, 2.99));
        pancakeHouseMenu.add(new MenuItem("Blueberry Pancake",
                "Pancakes made with fresh blueberries",
                true, 3.49));
        cafeMenu.add(new MenuItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99));
        cafeMenu.add(new MenuItem("Burrito",
                "A large burrito ,with whole printo beans,salsa,guacamole",
                true, 4.29));
        Waitress waitress = new Waitress(allMenus);
        //waitress.printMenu();
        waitress.printVegerarianMenu();
    }

    public void testCompositeIterator(Menu component) {
        CompositeIterator iterator = new CompositeIterator(component.createIterator());
        while (iterator.hasNext()) {
            MenuComponent component1 = (MenuComponent) iterator.next();
        }
    }
}

package designpattern.iteratorpattern.restaurantMenu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 好处，女招待可以用接口Menu 和Iterator而不是具体的类来引用对象，从而减少依赖
 * 只需要关心这两个接口 由菜单类负责提供具体的迭代器
 */
public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;
    private ArrayList menus;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    public Waitress(ArrayList menus) {
        this.menus = menus;
    }

    public void printMenuList() {
        Iterator menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            printMenu(menu.createIterator());
        }
    }

    public void printMenu() {
        System.out.println("MENU\n----\n");
        if (pancakeHouseMenu != null) {
            System.out.println("Breakfast\n----");
            Iterator pancakeIterator = pancakeHouseMenu.createIterator();
            printMenu(pancakeIterator);
        }
        if (dinerMenu != null) {
            System.out.println("Dinner\n----");
            Iterator dinerIterator = dinerMenu.createIterator();
            printMenu(dinerIterator);
        }
        if (cafeMenu != null) {
            System.out.println("Cafe\n----");
            Iterator cafeIterator = cafeMenu.createIterator();
            printMenu(cafeIterator);
        }
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ",");
            System.out.print(menuItem.getPrice() + "--");
            System.out.println(menuItem.getDescription());
        }
    }
}

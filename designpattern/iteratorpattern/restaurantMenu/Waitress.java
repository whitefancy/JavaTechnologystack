package designpattern.iteratorpattern.restaurantMenu;

import java.util.ArrayList;
import java.util.Iterator;

class Waitress {
    private ArrayList menus;

    Waitress(ArrayList menus) {
        this.menus = menus;
    }

    void printMenu() {
        Iterator menuIterator = menus.iterator();
        System.out.println("MENU\n----\n");
        while (menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            printMenu(menu.createIterator());
            System.out.println();
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

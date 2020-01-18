package designpattern.iteratorpattern.restaurantMenu;

import java.util.ArrayList;

public class MenuTestDrive {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();
        ArrayList menus = new ArrayList(3);
        menus.add(pancakeHouseMenu);
        menus.add(dinerMenu);
        menus.add(cafeMenu);
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);
        waitress.printMenu();
    }
}

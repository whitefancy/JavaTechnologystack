package designpattern.iteratorpattern.restaurantMenu;

import java.util.ArrayList;

public class PancakeHouseIterator implements Iterator {
    private ArrayList menuItems;
    private int position = 0;

    public PancakeHouseIterator(ArrayList menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.size() || menuItems.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        position += 1;
        return menuItems.get(position - 1);
    }
}

package designpattern.iteratorpattern.restaurantMenu;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator {
    private MenuItem[] list;
    private int position = 0;

    DinerMenuIterator(MenuItem[] list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (position >= list.length || list[position] == null)
            /*
            因为我们使用的是固定长度的数组，所以长度不会为0，但是可能某些项为null
             */ {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {

        MenuItem menuItem = list[position];
        position = position + 1;
        return menuItem;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException
                    ("You can't remove an item until you've done at least one next()");
        }
        if (list[position - 1] != null) {
            for (int i = position - 1; i < (list.length - 1); i++) {
                list[i] = list[i - 1];
            }
            list[list.length - 1] = null;
        }
    }
}

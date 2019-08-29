package designpattern.iteratorandcombinationpattern.iteratorpattern;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator {
    private MenuItem[] items;
    private int position = 0;

    DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null)
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

        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }
}

package designpattern.compositepattern.restaurantMenu;


import java.util.Iterator;

/**
 * 空迭代器
 * hasNext方法永远返回false
 */
public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}

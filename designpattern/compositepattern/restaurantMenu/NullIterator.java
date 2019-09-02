package designpattern.compositepattern.restaurantMenu;

import designpattern.iteratorpattern.prototype.Iterator;

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
    public boolean remove() {
        throw new UnsupportedOperationException();
    }
}

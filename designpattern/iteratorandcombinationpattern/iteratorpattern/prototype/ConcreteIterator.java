package designpattern.iteratorandcombinationpattern.iteratorpattern.prototype;

public class ConcreteIterator implements Iterator {
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
        return false;
    }
}

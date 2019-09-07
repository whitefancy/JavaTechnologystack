package designpattern.iteratorpattern.prototype;

public interface Iterator {
    boolean hasNext();

    Object next();

    boolean remove();
}

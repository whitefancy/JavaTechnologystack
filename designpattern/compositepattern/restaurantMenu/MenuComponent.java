package designpattern.compositepattern.restaurantMenu;


import java.util.Iterator;

abstract class MenuComponent {
    public Iterator iterator;

    String getName() {
        throw new UnsupportedOperationException();
    }

    String getDescription() {
        throw new UnsupportedOperationException();
    }

    double getPrice() {
        throw new UnsupportedOperationException();
    }

    boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    void print() {
        throw new UnsupportedOperationException();
    }

    void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    void remove(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    Iterator createIterator() {
        throw new UnsupportedOperationException();
    }
}

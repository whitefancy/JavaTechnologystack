package designpattern.compositepattern.restaurantMenu;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
    private ArrayList menuComponents = new ArrayList();
    private String name;
    private String description;

    Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("-----------------");
        Iterator iterator = menuComponents.iterator();
        /*
        树的先续遍历
         */
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }

    @Override
    void add(MenuComponent component) {
        menuComponents.add(component);
    }

    @Override
    void remove(MenuComponent component) {
        menuComponents.remove(component);
    }

    @Override
    MenuComponent getChild(int index) {
        /*
        可以用列表的列表来表示树形结构
         */
        return (MenuComponent) menuComponents.get(index);
    }

    public Iterator createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }
}

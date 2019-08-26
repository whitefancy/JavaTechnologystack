package designpattern.templatemethodpattern.arraysort;

import java.util.Arrays;

/**
 * 虽然Arrays 的sort方法是一个静态方法，而不是一个抽象类继承
 * 但是它的实现仍然符合模板方法的精神，
 * 而且由于是静态方法，不用继承就可以使用这个方法，使得排序更有弹性，更有用。
 */
public class DuckSortTestDrive {
    public static void main(String[] args) {
        Duck[] ducks = {
                new Duck("zhao", 3),
                new Duck("qian", 2),
                new Duck("sun", 3),
                new Duck("li", 6),
                new Duck("zhou", 1),
        };
        System.out.println("Before sorting...");
        DuckSortTestDrive.display(ducks);
        Arrays.sort(ducks);
        System.out.println("After sorting...");
        DuckSortTestDrive.display(ducks);
    }

    private static void display(Duck[] ducks) {
        for (int i = 0; i < ducks.length; i++) {
            System.out.println(ducks[i]);
        }
    }
}

package designpattern.templatemethodpattern.arraysort;

public class Duck implements Comparable {
    private String name;
    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Duck otherDuck = (Duck) o;
        if (weight < otherDuck.weight) {
            return -1;
        } else if (weight == otherDuck.weight) {
            return 0;
        } else {
            return 1;
        }
        /*
        排序结果默认是小的在前，大的在后。
        可以调用reverse翻转。
         */
    }
}

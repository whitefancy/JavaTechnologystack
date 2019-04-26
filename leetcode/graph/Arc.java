package leetcode.graph;

public class Arc {
    int tail;
    int weight;

    public Arc(int tail, int weight) {
        this.tail = tail;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
}

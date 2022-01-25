package Versions.jvmusage;

public class Test extends TB {
    public Test(int i, int j) {
        int a = super.test1(i, j);
        a = test1(i, j);
    }

    public int test1(int i, int j) {
        return i + j + 3;
    }

    public static void main(String[] args) {
        new Test(-1, -2);
    }
}

class TB {
    public TB() {

    }

    public int test1(int i, int j) {
        return i + j;
    }
}
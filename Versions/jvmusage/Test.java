package Versions.jvmusage;

import java.lang.annotation.*;

public class Test extends TB {
    static int i;
    int j;

    public Test() {
        synchronized (this) {
            i++;
        }
    }

    /**
     * 自定义的Annotation。     自定义注解
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @interface Inheritable {
    }

    public synchronized static void test1(int j) throws Exception {
        if (j == 0) {
            throw new Exception("test");
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}

class TB {

}
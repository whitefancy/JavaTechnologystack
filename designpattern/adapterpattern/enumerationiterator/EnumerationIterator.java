package designpattern.adapterpattern.enumerationiterator;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Consumer;

public class EnumerationIterator implements Iterator {
    private Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    /**
     * 很遗憾，当我们不能支持迭代器的方法，必须放弃，比如抛出异常
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        throw new UnsupportedOperationException();
    }
    /*
    我们还可以根据旧接口的内容，给适配器增加一些其他的特性，例如，电涌保护，指示灯，警报声等。
     */
}

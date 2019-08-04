package designpattern.decoratorpattern.myjavaio;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 看过Java I/O的类图之后，可以编写自己的输入装饰者
 * 把所有的大写字母都转成小写
 * 扩展FilterInputStream（所有InputStream的抽象装饰者）
 */
public class LowerCaseInputStream extends FilterInputStream {
        /*
    Java.io类的InputStream就是抽象组件
    具体组件包括FileInputStream StringBufferInputStream ByteArrayInputStream
    装饰器抽象类是 FilterInputStream
    具体装饰器类是PushbackInputStream BufferedInputStream DataInputStream LineNumberInputStream
     */
    /*
    输出流， Reader/Writer流也是雷同的
    装饰者模式的缺点，设计中有大量的小类，数量实在太多。
    了解装饰者的工作原理，就可以使用大量装饰的API，辨别他们是怎么组织的，方便用包装方式 取得想要的行为
     */

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    public LowerCaseInputStream(InputStream in) {
        /*
        在这个装饰者模式里，被装饰的组件被放在装饰器类里，而不是每一个具体装饰器类里，
        这样，就要求装饰器不再是抽象的，而是一个普通类，每个具体装饰器构造时，使用的是父类的InputStream实例，
        这与星巴兹的结构有所差别，本质是一样的，但更高明。
         */
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int offset, int len) throws IOException {
        int result = super.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}

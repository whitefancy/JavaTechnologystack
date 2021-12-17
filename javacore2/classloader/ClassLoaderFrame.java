package javacore2.classloader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClassLoaderFrame extends JFrame {
    private static final long serialVersionUID = -786655895239662291L;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JTextField keyField = new JTextField("4", 4);
    private JTextField nameField = new JTextField("javacore2.classloader.Test1", 30);

    public ClassLoaderFrame() {
        setSize(ClassLoaderFrame.DEFAULT_WIDTH, ClassLoaderFrame.DEFAULT_HEIGHT);
        setLayout(new GridBagLayout());
        add(new JLabel("Class"));
        add(nameField);
        JButton loadButton = new JButton("load");
        add(loadButton);
        loadButton.addActionListener(event -> runClass(nameField.getText(), keyField.getText()));
        pack();
    }

    private void runClass(String name, String key) {
        ClassLoader loader = new CyptoClassLoader(Integer.parseInt(key));
        try {
            Class<?> c = loader.loadClass(name);
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, (Object) new String[]{});
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

}

//反射
//能够分析类能力的程序称为反射
//Class类
//为所有的对象维护的被称为运行时的类型标识，跟踪每个对象所属的类。虚拟机利用运行时的类型信息选择相应的方法执行
//返回Class类型的实例
//getClass
//forName(String s)
//会抛出已检查异常，必须提供异常处理器
//任意Java类型T.class
//一个Class对象实际上表示的是一个类型
//这个类型未必是类，例如 int.class是一个Class类型的对象
//在启动时，包含main方法的类被加载，它会加载所有所需要的类
//实际上是一个泛型类
//动态创建一个类的实例
//e.getClass().newInstance()
//利用反射分析类的能力
//Field
//Method
//invoke（）
//允许调用包装在当前Method对象中的方法
//Constructor
//运行时使用反射分析对象
//Employee harry = new Employee("Harry Hacker", 35000, 10, 1, 1989);
//Class cl = harry.getClass0； // the class object representing Employee
//Field f = cl .getDeclaredField('name"): // the name field of the Employee class
//Object v = f.get(harry); // the value of the name field of the harry object , i .e., the String object "Harry Hacker"
//使用反射编写泛型数组代码
//Class cl = a.getClassO；
//if (Icl .isArrayO) return null ;
//Class componentType = cl .getComponentType0；
//int length = Array.getLength(a);
//Object newArray = Array.newlnstance(componentType, newLength):
//System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
//return newArray;
//调用任意方法
//Method ml = Employee.class.getMethod("getName");
//Method m2 = Employee.class.getMethod("raiseSalary", double.class);
//double y = (Double) f.invoke(null, x);
//继承的设计技巧
//将公共操作和域放在超类
//不使用protected域
//因为子类集合是无限制的，可以任意派生
//子类编写代码可以直接访问protected的实例域，破坏封装性
//同一个包下也可以任意访问
//实现is a关系
//除非所有继承到的方法都有意义，否则不使用继承
//覆盖方法时，不要改变预期的行为
//使不要过多使用反射
//编译器很难帮助发现错误
//使用反射的常见场景有以下两种：
//
//不能明确接口调用哪个函数，需要根据传入的参数在运行时决定。
//不能明确传入函数的参数类型，需要在运行时处理任意对象。
//【引申1】不推荐使用反射的理由有哪些？
//
//与反射相关的代码，经常是难以阅读的。在软件工程中，代码可读性也是一个非常重要的指标。
//Go 语言作为一门静态语言，编码过程中，编译器能提前发现一些类型错误，但是对于反射代码是无能为力的。所以包含反射相关的代码，很可能会运行很久，才会出错，这时候经常是直接 panic，可能会造成严重的后果。
//反射对性能影响还是比较大的，比正常代码运行速度慢一到两个数量级。所以，对于一个项目中处于运行效率关键位置的代码，尽量避免使用反射特性。
class CyptoClassLoader extends ClassLoader {
    private int key;

    public CyptoClassLoader(int k) {
        key = k;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        获取Class对象的三种方式
//        Object ——> getClass();
//        class属性 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
//        通过Class类的静态方法：forName（String className）(常用)
//                Class c1 = Test.class; //这说明任何一个类都有一个隐含的静态成员变量class，这种方式是通过获取类的静态成员变量class得到的()
//        Class c2 = test.getClass();// test是Test类的一个对象，这种方式是通过一个类的对象的getClass()方法获得的 (对于基本类型无法使用这种方法)
//        Class c3 = Class.forName("com.catchu.me.reflect.Test"); //这种方法是Class类调用forName方法，通过一个类的全量限定名获得（基本类型无法使用此方法）
//        通过反射创建对象
//        通过反射有两种方法可以创建对象：
//        java.lang.reflect.Constructor.newInstance()
//        Class.newInstance()

        Class<?> cl = null;
        try {
            byte[] classBytes = null;
            classBytes = loadClassBytes(name);
            cl = defineClass(name, classBytes, 0, classBytes.length);
            if (cl == null) {
                throw new ClassNotFoundException(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cl;
    }

    private byte[] loadClassBytes(String name) throws IOException {
        String cname = name.replace('.', '/') + ".caesar";
        byte[] bytes = Files.readAllBytes(Paths.get(cname));
        //解密算法
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - key);
        }
        return bytes;
    }
}
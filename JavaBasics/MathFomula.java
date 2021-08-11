package JavaBasics;

public class MathFomula {

    public void test() {
        System.out.println(combination(5, 3));
    }

    //组合数 C(n,m)=n!/(m!*(n-m)!)
    public int combination(int n, int m) {
        long temp = 1;
        for (int i = m + 1; i <= n; i++) {
            temp *= i;
        }
        for (int i = 2; i <= n - m; i++) {
            temp /= i;
        }
        return (int) temp;
    }

    //排列数 A(n,m)=n!/(n-m)!
    public int arrangement(int n, int m) {
        long temp = 1;
        for (int i = m + 1; i <= n; i++) {
            temp *= i;
        }
        return (int) temp;
    }

    public static void main(String[] args) {
//        静态常量
//        Math 类中包含 E 和 PI 两个静态常量，正如它们名字所暗示的，它们的值分别等于 e（自然对数）和 π（圆周率）。
//        例 1
//        调用 Math 类的 E 和 PI 两个常量，并将结果输出。代码如下：
        System.out.println("E 常量的值：" + Math.E);
        System.out.println("PI 常量的值：" + Math.PI);
//        执行上述代码，输出结果如下：
//        E 常量的值：2.718281828459045
//        PI 常量的值：3.141592653589793

//求最大值、最小值和绝对值
//在程序中常见的就是求最大值、最小值和绝对值问题，如果使用 Math 类提供的方法可以很容易实现。这些方法的说明如表 1 所示。
//表 1 求最大值、最小值和绝对值的方法
//方法	说明
//static int abs(int a)	返回 a 的绝对值
//static long abs(long a)	返回 a 的绝对值
//static float abs(float a)	返回 a 的绝对值
//static double abs(double a)	返回 a 的绝对值
//static int max(int x,int y)	返回 x 和 y 中的最大值
//static double max(double x,double y)	返回 x 和 y 中的最大值
//static long max(long x,long y)	返回 x 和 y 中的最大值
//static float max(float x,float y)	返回 x 和 y 中的最大值
//static int min(int x,int y)	返回 x 和 y 中的最小值
//static long min(long x,long y)	返回 x 和 y 中的最小值
//static double min(double x,double y)	返回 x 和 y 中的最小值
//static float min(float x,float y)	返回 x 和 y 中的最小值
        //求整运算
        //Math 类的求整方法有很多，详细说明如表 2 所示。
        //表 2 取整方法及其说明
        //方法	说明
        //static double ceil(double a)	返回大于或等于 a 的最小整数
        //static double floor(double a)	返回小于或等于 a 的最大整数
        //static double rint(double a)	返回最接近 a 的整数值，如果有两个同样接近的整数，则结果取偶数
        //static int round(float a)	将参数加上 1/2 后返回与参数最近的整数
        //static long round(double a)	将参数加上 1/2 后返回与参数最近的整数，然后强制转换为长整型
        //三角函数运算
        //Math 类中包含的三角函数方法及其说明如表 3 所示。
        //需要注意：通常角度和弧度转换是不精确的。
        //表 3 三角函数方法及其说明
        //方法	说明
        //static double sin(double a)	返回角的三角正弦值，参数以孤度为单位
        //static double cos(double a)	返回角的三角余弦值，参数以孤度为单位
        //static double asin(double a)	返回一个值的反正弦值，参数域在 [-1,1]，值域在 [-PI/2,PI/2]
        //static double acos(double a)	返回一个值的反余弦值，参数域在 [-1,1]，值域在 [0.0,PI]
        //static double tan(double a)	返回角的三角正切值，参数以弧度为单位
        //static double atan(double a)	返回一个值的反正切值，值域在 [-PI/2,PI/2]
        //static double toDegrees(double angrad)	将用孤度表示的角转换为近似相等的用角度表示的角
        //staticdouble toRadians(double angdeg)	将用角度表示的角转换为近似相等的用弧度表示的角
        //指数运算
        //指数的运算包括求方根、取对数及其求 n 次方的运算。在 Math 类中定义的指数运算方法及其说明如表 4 所示。
        //表 4 指数方法及其说明
        //方法	说明
        //static double exp(double a)	返回 e 的 a 次幂
        //static double pow(double a,double b)	返回以 a 为底数，以 b 为指数的幂值
        //static double sqrt(double a)	返回 a 的平方根
        //static double cbrt(double a)	返回 a 的立方根
        //static double log(double a)	返回 a 的自然对数，即 lna 的值
        //static double log10(double a)	返回以 10 为底 a 的对数
        //精度调整NumberFormat，DecimalFormat类：
        //　java对文字，数字的格式化，是有一个公共的父类的Format。
        //NumberFormat和DecimalFormat都是它的子类关于数字的。
        //DateFormat和SimpleDateFormat也是它的子类关于文字的。
        //(public abstract class NumberFormat extends Format)
        //用java.text.NumberFormat类对输出的数字结果进行必要的格式化。
        //要特别注意的是 NumberFormat和DecimalFormat是线程不安全的。 这意味你如果同时有多个线程操作一个format实例对象，会出现意想不到的结果。
        //解决方法有两个：
        //为每个线程都创建一个 format实例，通过ThreadLocal 来给每个线程都产生一个本地实例。
        //NumberFormat
        //NumberFormat帮助您格式化和解析任何区域设置的数字。您的代码可以完全独立于小数点，千位分隔符的区域设置约定，甚至是使用的特定十进制数字，或者数字格式是否为十进制。
        //获取NumberFormat实例
        ////创建 一个整数格式 地区用系统默认的
        //NumberFormat integerNumber = NumberFormat.getIntegerInstance(Locale.getDefault());
        //1
        //2
        //使用getInstance或getNumberInstance获取正常的数字格式。
        //使用getIntegerInstance得到的整数格式。
        //使用getCurrencyInstance来获取货币数字格式。
        //使用getPercentInstance获取显示百分比的格式。
        //DecimalFormat
        //DecimalFormat是NumberFormat十进制数字格式的具体子类 。它具有多种功能，旨在解析和格式化任何语言环境中的数字，包括支持西方，阿拉伯语和印度语数字。它还支持不同类型的数字，包括整数（123），定点数（123.4），科学记数法（1.23E4），百分比（12％）和货币金额（123美元）。所有这些都可以本地化。
        //设置Pattern
        //DecimalFormat作为NumberFormat的具体实现子类，最大的特点就是 可以使用Pattern。来实现最大程度的对数据格式进行定制。
        //一个Pattern中的许多字符是按字面意思理解的;它们在解析期间匹配，在格式化期间输出不变,就是字符在Pattern中 不影响最后的数字格式化另一方面，特殊字符代表其他字符、字符串或字符类。如果要以文字形式出现在前缀或后缀中，必须引用它们(除非另有说明)。
        //
        //
        //使用该类如下方法类实例化一个NumberFormat对象：
        //   public static final NumberFormat getInstance()
        //  然后用该对象调用如下方法可以格式化数字number(返回字符串对象)：
        //   public final String format(double number)
        //
        //  NumberFormat类有如下常用方法：
        //  public void setMaximumFractionDigits(int newValue)//设置数的小数部分所允许的最大位数。
        //  public void setMaximumIntegerDigits(int newValue)//设置数的整数部分所允许的最大位数。
        //  public void setMinimumFractionDigits(int newValue)//设置数的小数部分所允许的最小位数。
        //  public void setMinimumIntegerDigits(int newValue)//设置数的整数部分所允许的最小位数。

        //BigInteger类、BigDecimal类：
        //  java.math包中的BigInteger类和BigDecimal类分别提供任意精度的整数和小数运算。
        //  两个类设计思想一样，这里只对BigInterger类稍做介绍，细节可以查看JDK6API参考。
        //
        //  构造方法如下：
        //   BigInteger(String val)  //将 BigInteger 的十进制字符串表示形式转换为 BigInteger。
        //   还有很多考虑周全的构造函数，建议要准备写特殊需求的BigInteger前先认真翻下JDK。
        //
        //  常用方法：
        //   abs()  //返回其值是此BigInteger的绝对值的BigInteger。
        //   add(BigInteger val)  //返回其值为(this+val)的BigInteger。
        //   subtract(BigInteger val)  //返回其值为(this-val)的BigInteger。
        //   multiply(BigInteger val)  // 返回其值为(this*val)的BigInteger。
        //   divide(BigInteger val)  //返回其值为(this/val)的BigInteger。
        //   remainder(BigInteger val)  //返回其值为(this%val)的BigInteger。
        //   compareTo(BigInteger val)  //将此BigInteger与指定的BigInteger进行比较。返回值1、0、-1分别表示大于、等于、小于
        //   pow(int exponent)  //返回当前大数的exponent次幂。
        //   toString()  //返回此BigInteger的十进制字符串表示形式。
        //   toString(int radix)  //返回此BigInteger的给定基数(radix进制)的字符串表示形式。
        

    }
}

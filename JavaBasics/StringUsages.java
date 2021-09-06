package JavaBasics;

import java.util.Date;
import java.util.Locale;

public class StringUsages {

    //String 方法
    //下面是 String 类支持的方法，更多详细，参看 Java String API 文档:
    //SN(序号)	方法描述
    //1	char charAt(int index)
    //返回指定索引处的 char 值。
    //2	int compareTo(Object o)
    //把这个字符串和另一个对象比较。
    //3	int compareTo(String anotherString)
    //按字典顺序比较两个字符串。
    //4	int compareToIgnoreCase(String str)
    //按字典顺序比较两个字符串，不考虑大小写。
    //5	String concat(String str)
    //将指定字符串连接到此字符串的结尾。
    //6	boolean contentEquals(StringBuffer sb)
    //当且仅当字符串与指定的StringBuffer有相同顺序的字符时候返回真。
    //7	static String copyValueOf(char[] data)
    //返回指定数组中表示该字符序列的 String。
    //8	static String copyValueOf(char[] data, int offset, int count)
    //返回指定数组中表示该字符序列的 String。
    //9	boolean endsWith(String suffix)
    //测试此字符串是否以指定的后缀结束。
    //10	boolean equals(Object anObject)
    //将此字符串与指定的对象比较。
    //11	boolean equalsIgnoreCase(String anotherString)
    //将此 String 与另一个 String 比较，不考虑大小写。
    //12	byte[] getBytes()
    // 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
    //13	byte[] getBytes(String charsetName)
    //使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
    //14	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
    //将字符从此字符串复制到目标字符数组。
    //15	int hashCode()
    //返回此字符串的哈希码。
    //16	int indexOf(int ch)
    //返回指定字符在此字符串中第一次出现处的索引。
    //17	int indexOf(int ch, int fromIndex)
    //返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。
    //18	int indexOf(String str)
    // 返回指定子字符串在此字符串中第一次出现处的索引。
    //19	int indexOf(String str, int fromIndex)
    //返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
    //20	String intern()
    // 返回字符串对象的规范化表示形式。
    //21	int lastIndexOf(int ch)
    // 返回指定字符在此字符串中最后一次出现处的索引。
    //22	int lastIndexOf(int ch, int fromIndex)
    //返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。
    //23	int lastIndexOf(String str)
    //返回指定子字符串在此字符串中最右边出现处的索引。
    //24	int lastIndexOf(String str, int fromIndex)
    // 返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。
    //25	int length()
    //返回此字符串的长度。
    //26	boolean matches(String regex)
    //告知此字符串是否匹配给定的正则表达式。
    //27	boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
    //测试两个字符串区域是否相等。
    //28	boolean regionMatches(int toffset, String other, int ooffset, int len)
    //测试两个字符串区域是否相等。
    //29	String replace(char oldChar, char newChar)
    //返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
    //30	String replaceAll(String regex, String replacement)
    //使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
    //31	String replaceFirst(String regex, String replacement)
    // 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
    //32	String[] split(String regex)
    //根据给定正则表达式的匹配拆分此字符串。
    //33	String[] split(String regex, int limit)
    //根据匹配给定的正则表达式来拆分此字符串。
    //34	boolean startsWith(String prefix)
    //测试此字符串是否以指定的前缀开始。
    //35	boolean startsWith(String prefix, int toffset)
    //测试此字符串从指定索引开始的子字符串是否以指定前缀开始。
    //36	CharSequence subSequence(int beginIndex, int endIndex)
    // 返回一个新的字符序列，它是此序列的一个子序列。
    //37	String substring(int beginIndex)
    //返回一个新的字符串，它是此字符串的一个子字符串。
    //38	String substring(int beginIndex, int endIndex)
    //返回一个新字符串，它是此字符串的一个子字符串。
    //39	char[] toCharArray()
    //将此字符串转换为一个新的字符数组。
    //40	String toLowerCase()
    //使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
    //41	String toLowerCase(Locale locale)
    // 使用给定 Locale 的规则将此 String 中的所有字符都转换为小写。
    //42	String toString()
    // 返回此对象本身（它已经是一个字符串！）。
    //43	String toUpperCase()
    //使用默认语言环境的规则将此 String 中的所有字符都转换为大写。
    //44	String toUpperCase(Locale locale)
    //使用给定 Locale 的规则将此 String 中的所有字符都转换为大写。
    //45	String trim()
    //返回字符串的副本，忽略前导空白和尾部空白。
    //46	static String valueOf(primitive data type x)
    //返回给定data type类型x参数的字符串表示形式。
    //47	contains(CharSequence chars)
    //判断是否包含指定的字符系列。
    //48	isEmpty()
    //判断字符串是否为空。
    //格式化字符串
    //String fs;
    //fs = String.format("浮点型变量的值为 " +
    //                   "%f, 整型变量的值为 " +
    //                   " %d, 字符串变量的值为 " +
    //                   " %s", floatVar, intVar, stringVar);
    //StringBuffer 方法
    //以下是 StringBuffer 类支持的主要方法：
    //序号	方法描述
    //1	public StringBuffer append(String s)
    //将指定的字符串追加到此字符序列。
    //2	public StringBuffer reverse()
    // 将此字符序列用其反转形式取代。
    //3	public delete(int start, int end)
    //移除此序列的子字符串中的字符。
    //4	public insert(int offset, int i)
    //将 int 参数的字符串表示形式插入此序列中。
    //5	insert(int offset, String str)
    //将 str 参数的字符串插入此序列中。
    //6	replace(int start, int end, String str)
    //使用给定 String 中的字符替换此序列的子字符串中的字符。
    //序号	方法描述
    //1	int capacity()
    //返回当前容量。
    //2	char charAt(int index)
    //返回此序列中指定索引处的 char 值。
    //3	void ensureCapacity(int minimumCapacity)
    //确保容量至少等于指定的最小值。
    //4	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
    //将字符从此序列复制到目标字符数组 dst。
    //5	int indexOf(String str)
    //返回第一次出现的指定子字符串在该字符串中的索引。
    //6	int indexOf(String str, int fromIndex)
    //从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引。
    //7	int lastIndexOf(String str)
    //返回最右边出现的指定子字符串在此字符串中的索引。
    //8	int lastIndexOf(String str, int fromIndex)
    //返回 String 对象中子字符串最后出现的位置。
    //9	int length()
    // 返回长度（字符数）。
    //10	void setCharAt(int index, char ch)
    //将给定索引处的字符设置为 ch。
    //11	void setLength(int newLength)
    //设置字符序列的长度。
    //12	CharSequence subSequence(int start, int end)
    //返回一个新的字符序列，该字符序列是此序列的子序列。
    //13	String substring(int start)
    //返回一个新的 String，它包含此字符序列当前所包含的字符子序列。
    //14	String substring(int start, int end)
    //返回一个新的 String，它包含此序列当前所包含的字符子序列。
    //15	String toString()
    //返回此序列中数据的字符串表示形式。
    public static void main(String[] args) {
//            String类的format()方法用于创建格式化的字符串以及连接多个字符串对象。熟悉C语言的同学应该记得C语言的sprintf()方法，两者有类似之处。format()方法有两种重载形式。
//
//format(String format, Object... args) 新字符串使用本地语言环境，制定字符串格式和参数生成格式化的新字符串。
//
//format(Locale locale, String format, Object... args) 使用指定的语言环境，制定字符串格式和参数生成格式化的字符串。
        String str = null;
        str = String.format("Hi,%s", "张三");
        System.out.println(str);
        str = String.format("Hi,%s:%s.%s", "张三", "李四", "王五");
        System.out.println(str);
        String.format("%.1f", 34.543);
        Date date = new Date();
        //b的使用，月份简称
        str = String.format(Locale.US, "英文月份简称：%tb", date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n", date);
        //B的使用，月份全称
        str = String.format(Locale.US, "英文月份全称：%tB", date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n", date);
        //a的使用，星期简称
        str = String.format(Locale.US, "英文星期的简称：%ta", date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n", date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n", date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n", date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n", date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n", date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n", date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te", date);
        //$使用
        str = String.format("格式参数$的使用：%1$d,%2$s", 99, "abc");
        System.out.println(str);
        //+使用
        System.out.printf("显示正负数的符号：%+d与%d%n", 99, -99);
        //补O使用
        System.out.printf("最牛的编号是：%03d%n", 7);
        //空格使用
        System.out.printf("Tab键的效果是：% 8d%n", 7);
        //.使用
        System.out.printf("整数分组的效果是：%,d%n", 9989997);
        //空格和小数点后面个数
        System.out.printf("一本书的价格是：% 50.5f元%n", 49.8);
//        如果您使用StringBuilder，StringBuffer，则它们是可变的String，并且您的值将在更改时进行修改。
//        当您深入研究时，Java String会带来许多令人困惑的理解。当使用“ ==”时，2个具有相同值的不同字符串将返回该内存地址的相同引用。例如。
        String a1 = "abc";
        String a2 = "abc";
//        a1 == a2; //returns true because a1 and a2 points to same reference (but not always!)
//        a1 == new String("abc") ;//returns false
/**Do use "equals", not == for string's value comparison**/
//        如果您可以全神贯注于内存对象引用：
        String s1 = "Hello, World!"; //let's say it's allocated to memory address 0x0012
        String s2 = s1; //s2 points to same memory address 0x0012
        s1 = "Goodbye, World!"; //s1 points to new memory address 0x1113
        System.out.println(s2); //printing value in still in memory address 0x0012
//        相当于，s1指向新对象，s2指向旧对象。
//        Java语言为“+”连接符（字符串连接符）以及对象转换为字符串提供了特殊的支持，字符串对象可以使用“+”连接其他对象。String类的部分源码如下
//        public final class String
//                implements java.io.Serializable, Comparable<String>, CharSequence {
//            /** The value is used for character storage. */
//            private final char value[];
//            /** Cache the hash code for the string */
//            private int hash; // Default to 0
//    ...
//        }
//        从上面可以看出
//        1）String类被final关键字修饰，意味着String类不能被继承，并且它的成员方法都默认为final方法；字符串一旦创建就不能再修改。
//        2）String类实现了Serializable、CharSequence、 Comparable接口。
//        3）String实例的值是通过字符数组实现字符串存储的。

    }
}

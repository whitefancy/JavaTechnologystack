package JavaBasics;

public class Notes {
    public static void main(String[] args) {
        //&和&&的区别。
        //&和&&都可以用作逻辑与的运算符，表示逻辑与（and），当运算符两边的表达式的结果都为true时，整个运算结果才为true，否则，只要有一方为false，则结果为false。
        //&&还具有短路的功能， &还可以用作位运算符，
        //&和&&的区别。
        //&和&&都可以用作逻辑与的运算符，表示逻辑与（and），当运算符两边的表达式的结果都为true时，整个运算结果才为true，否则，只要有一方为false，则结果为false。
        //&&还具有短路的功能， &还可以用作位运算符，
        
//switch语句能否作用在byte上，能否作用在long上，能否作用在String上?
//在Java 5以前，switch(expr)中，expr只能是byte、short、char、int。从Java 5开始，Java中引入了枚举类型，expr也可以是enum类型，从Java 7开始，expr还可以是字符串（String），但是长整型（long）在目前所有的版本中都是不可以的。
//总结起来就是swtich 可以作用在byte 上，不能作用在long 上，也能作用在String上。

        //Object类，所有类的超类
        //只有基本类型不是对象
        //所有的数组不管是对象数组还是基本类型的数组都扩展了Object类

        //char型变量中能不能存贮一个中文汉字?为什么?
        //char型变量是用来存储Unicode编码的字符的，unicode编码字符集中包含了汉字，所以，char型变量中当然可以存储汉字啦。
        // 不过，如果某个特殊的汉字没有被包含在unicode编码字符集中，那么，这个char型变量中就不能存储这个特殊汉字。
    }
}

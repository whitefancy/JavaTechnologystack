package javacore;

public class ExceptionUsage {
    //Throwable
    //Error
    //描述了 Java 运行时系统的内部错误和资源耗尽错误
    //应用程序不应该抛出这种类型的对象。 如果出现了这样的内部错误， 除了通告给用户，并尽力使程序安全地终止之外， 再也无能为力了。这种情况很少出现。抛出这种类型的对象。 如果出现了这样的内部错误， 除了通告给用户，并尽力使程序安全地终止之外， 再也无能为力了。这种情况很少出现。
    //Exception
    //IOException
    //程序本身没有问题， 但由于像 I/O 错误这类 问题导致的异常属于其他异常
    //不是派生于RuntimeException
    //试图在文件尾部后面读取数据。 •试图打开一个不存在的文件。 •试图根据给定的字符串查找 Class 对象， 而这个字符串表示的类并不存在,，
    //RuntimeException
    //由程序错误导致的异常属于 RuntimeException
    //包含下面几种情况
    //错误的类型转换。 •数组访问越界 i •访问 null 指针
    //如果出现 RuntimeException 异常， 那么就一定是你的问题
    //在设计 Java 程序时， 需要关注 Exception 层次结构
}

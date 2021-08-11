package Versions.jdk6;

public class Main {
    public static void main(String[] args) {
//        1.增强的for循环语句 例如 for ( int number: computeNumbers() )
        Integer[] numbers = computeNumbers();
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum += numbers[i];

        for (int number : computeNumbers())
            sum += number;
//        2.监视和管理 堆已经满了产生一个Log允许你在堆满的时候运行脚本。
//        Java SE 6中对内存泄漏增强了分析以及诊断能力。当遇到java.lang.OutOfMemory异常的时候，可以得到一个完整的堆栈信息，
//        并且当堆已经满了的时候，会产生一个Log文件来记录这个致命错误。另外，JVM还添加了一个选项，允许你在堆满的时候运行脚本。
//        3.插入式注解处理 Annotations
//        插入式注解处理API(JSR 269)提供一套标准API来处理Annotations
//        4.安全性

    }

    private static Integer[] computeNumbers() {
        return null;
    }

}

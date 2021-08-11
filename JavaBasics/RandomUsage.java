package JavaBasics;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUsage {
    public static void main(String[] args) {
        //随机数生成
//        java.lang.Math.random() 方法的用法：
//        public static double random()
//        返回：一个大于等于0.0 且小于1.0的伪随机double类型的数。
//        如果需要返回符合在[min,max]范围的int型的整数：
        int min = 1, max = 5;
        int num = min + (int) (Math.random() * (max - min + 1));

//        方法二和方法一类似，只不过一个是Math库中的，一个是util中的。
//        实际上，java.util.Random类通常比java.lang.Math.random（）更可取。
//        尤其是，当标准库中有简单的API完成任务时，就无需重新发明随机整数生成轮。

        Random rand = new Random();
// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive
        int randomNum = rand.nextInt((max) + 1) + min;
        int r = ThreadLocalRandom.current().nextInt(min, max + 1);
//        在Java 1.7或更高版本中，执行此操作的标准方法如下：
//import java.util.concurrent.ThreadLocalRandom;
// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive
//        种方法的优点是不需要显式初始化java.util.Random实例，如果使用不当，可能会引起混乱和错误。

    }
}

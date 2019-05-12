package JavaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsOperation {

    public List test(){
        // Arrays
        Integer[] primes= new Integer[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,
                131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,
                281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,
                457,461,463,467,479,487,491,499,503,509,521,523,541,547,557,563,569,571,577,587,593,599,601,607,613,617,619,631,
                641,643,647,653,659,661,673,677,683,691,701,709,719,727,733,739,743,751,757,761,769,773,787,797,809,811,821,823};

        int ele = Arrays.binarySearch(primes,503);// 仅对有序数组可以用二分查找

        Integer[] subprimes = Arrays.copyOfRange(primes,4,23);// 数组复制

        boolean eq = Arrays.deepEquals(subprimes,primes);// 深相等，每一个元素都相等。这里不能用基本类型

        String s =Arrays.deepToString(subprimes);// 深打印 [[0, 2], [1, 2], [2, 0]]
        System.out.println(s);

        // List
        List<Integer> list = Arrays.asList(primes);// array to list 这里也只能用object 不能用基本类型

        Collections.shuffle(list);//洗牌 打乱顺序
        int max = Collections.max(list);// 找出最大值
        System.out.println(max);
        List b = Collections.EMPTY_LIST;//b 初始化为空List
        for (int i = 0; i < b.size(); i++) {
            // b.fori
        }
        for (int i = b.size() - 1; i >= 0; i--) {
            //b.forr
        }
        for (Object o : b) {
            //b.for
        }
        ((ArrayList) b).get(0);//b.cast 强制类型转换
        b.addAll(0,list);// 在index的位置插入集合
        System.out.println(b);// b.sout
        System.out.println("b = " + b);//b.soutv
        if (b == null) {
            // b.null
            // b,notnull
        }
        //b.arg 把b作为参数
        ((ArrayList) b).trimToSize();// 缩小b的存储到最小的b
        ((ArrayList) b).ensureCapacity(100);// 让b的Array长度至少是100，从100起步
        
        return b;//b.return
    }

}

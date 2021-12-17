package JavaBasics;

import java.util.*;
import java.util.stream.Collectors;

public class ListArray {

    public List test() {
        // Arrays
        Integer[] primes = new Integer[]{2, 3, 97, 809, 811, 821, 823};

        int ele = Arrays.binarySearch(primes, 503);// 仅对有序数组可以用二分查找

        Integer[] subprimes = Arrays.copyOfRange(primes, 4, 23);// 数组复制

        boolean eq = Arrays.deepEquals(subprimes, primes);// 深相等，每一个元素都相等。这里不能用基本类型

        String s = Arrays.deepToString(subprimes);// 深打印 [[0, 2], [1, 2], [2, 0]]
        System.out.println(s);

        // List
        //Arrays.asList()是泛型方法，传入的对象必须是对象数组。当传入一个原生数据类型数组时，Arrays.asList() 的真正得到的参数就不是数组中的元素，而是数组对象本身！此时List 的唯一元素就是这个数组，我们使用包装类型数组就可以解决这个问题
        List<Integer> list = Arrays.asList(primes);// array to list 这里也只能用object 不能用基本类型
        List b = Collections.EMPTY_LIST;//b 初始化为空List
        Collections.shuffle(list);//洗牌 打乱顺序
        int max = Collections.max(list);// 找出最大值
        System.out.println(max);
        Collections.rotate(list, 3);//将list后3个元素整体移到前面
        Collections.rotate(list, -3);//将list前3个元素整体移到后面
        Collections.indexOfSubList(list, b);// 返回子列表在父列表中第一次出现的位置索引
        Collections.lastIndexOfSubList(list, b);// 返回最后一次位置索引
        Collections.replaceAll(list, 2, 8);//整体替换值

// Set List, Deque,Map 都是线程不安全的。如果多线程，需要用Collenctions包装成线程同步
        List list2 = Collections.synchronizedList(new LinkedList());
        int a[] = {1, 2, 3, 2};
        List<Integer> l1 = Arrays.stream(a).boxed().collect(Collectors.toList());
        int b1[] = {4, 2, 90, 8, 98};
        int[] d3 = new int[a.length + b1.length];
        System.arraycopy(a, 0, d3, 0, a.length);
        System.arraycopy(b, 0, d3, a.length, b1.length);//拼接两个数组
        // 返回不可变的集合
        List list3 = Collections.singletonList(new ArrayList());

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
        b.addAll(0, list);// 在index的位置插入集合
        System.out.println(b);// b.sout
        System.out.println("b = " + b);//b.soutv
        if (b == null) {
            // b.null
            // b,notnull
        }
        //b.arg 把b作为参数
        ((ArrayList) b).trimToSize();// 缩小b的存储到最小的b
        ((ArrayList) b).ensureCapacity(100);// 让b的Array长度至少是100，从100起步
        int[] ints = list.stream().mapToInt((Integer in) -> in).toArray();
        int[] newData = Arrays.copyOfRange(ints, 2, 7);

        String[] myArray2 = {"3"};
//        不要在 foreach 循环里进行元素的 remove/add 操作
//        如何正确的将数组转换为ArrayList?
//        List list11 = new ArrayList<>(Arrays.asList("a", "b", "c"));
//        List myList8 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
//        Object[] myArray;
//        List myList = Arrays.stream(myArray).collect(Collectors.toList());
//        List<String> l18 = Lists.newArrayList(anotherListOrCollection); // from collection


        return b;//b.return
    }

}

class AnotherClass {
    //一个”.java”源文件中是否可以包括多个类（不是内部类）？有什么限制？
    //可以有多个类，但只能有一个public的类，并且public的类名必须与文件名相一致。
}
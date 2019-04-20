package leetcode.maths;

import java.util.Scanner;

class Fibonaccitail {
    //    题目描述
//    NowCoder号称自己已经记住了1-100000之间所有的斐波那契数。
//    为了考验他，我们随便出一个数n，让他说出第n个斐波那契数。当然，斐波那契数会很大。因此，如果第n个斐波那契数不到6位，则说出该数；否则只说出最后6位。
//
//    输入描述:
//    输入有多组数据。
//    每组数据一行，包含一个整数n (1≤n≤100000)。
//
//
//    输出描述:
//    对应每一组输入，输出第n个斐波那契数的最后6位。
//    对于这样类似的题目,最好的方式是进行预处理,把要计算的数值进行第一次计算的时候存储下来,然后剩下的测试用例只进行查找即可，因为查找比计算更加高效，再加上一次运算总比次次运算要快。不要担心第一次计算那么大数值时候回超时，因为这个数量级的运算还是很快的。
    int[] nums = new int[100001];
    Fibonaccitail(){
        nums[1]=1;
        nums[2]=2;
        int a =1;
        int b =2;
        int sum;
        for(int i =2;i<100000;)
        {
            sum=(a+b)%1000000;
            // time out
//            sum=a+b;
//            if(sum>=1000000)
//            {
//                sum-=1000000;
//            }
            //time out too;
            i++;
            nums[i]=sum;
            a=b;
            b=sum;
        }
    }
    public int checkFn(int n) {
        return nums[n];
    }

}
class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Fibonaccitail pr= new Fibonaccitail();
            System.out.println(pr.checkFn(n));
        }
    }
}
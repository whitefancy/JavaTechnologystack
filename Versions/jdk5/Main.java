package Versions.jdk5;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
//        jdk1.5的新特性：
//        1. 泛型ArrayList 例如list=new ArrayList()
        ArrayList list1=new ArrayList();
//        ------>
       ArrayList<Integer>list=new ArrayList<Integer>();
//        2 自动装箱/拆箱例如int i=list.get(0);
//        int i=list.get(0).parseInt();
        int i=list.get(0);//原始类型与对应的包装类不用显式转换
//        3 for-each例如 for(int i:a)
//            i=0;i<a.length;i++------------>for(int i:a){......}
        for(int i1:list){

        }
//        4 static import 例如sqrt();
//        Math.sqrt();--------------->sqrt();
        Math.sqrt(2);

    }
    //        5 变长参数 例如int sum(int ...intlist)
//        int sum(int ...intlist)有任意个参数,把他看作数组
    public int sum1(int ...intlist){
        int sum=0;
        for(int i:intlist){
            sum+=i;
        }
        return sum;
    }
}

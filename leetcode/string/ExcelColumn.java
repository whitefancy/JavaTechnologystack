package leetcode.string;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExcelColumn {
    public void test(){
     //   System.out.println(titleToNumber("ZY"));
        System.out.println(convertToTitle(1));
    }
//    给定一个Excel表格中的列名称，返回其相应的列序号。
//
//    例如，
//
//    A -> 1
//    B -> 2
//    C -> 3
//            ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//            ...
    public int titleToNumber1(String s) {
        char[] chs = s.toCharArray();
        int sum=0;
        int k =1;
        for(int i =chs.length-1;i>=0;i--){
            sum +=(chs[i]-'A'+1)*k;
            k*=26;
        }
        return sum;
    }
    public int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int sum=0;
        for(int i =0;i<chs.length;i++){
            sum = sum*26+(chs[i]-'A'+1);
        }
        return sum;
    }
//    给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
//    例如，
//
//            1 -> A
//    2 -> B
//    3 -> C
//    ...
//            26 -> Z
//    27 -> AA
//    28 -> AB
    public String convertToTitle(int n) {
        List<Integer> nums = new ArrayList<>();
        int x =26;
        while (n>0) {
            int b = n % x;
            if (b == 0){
                b=26;
            }
            nums.add(b);
            n = (n - b) / 26;
            if(b==0&&n==1)break;
        }
        Collections.reverse(nums);
        String title ="";
        for(Integer i:nums){
            char cNumber= (char) (i+'A'-1);
            title+=cNumber;
        }
        return title;
    }

}

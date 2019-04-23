package leetcode.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Factors {

    public List<Integer> getPrime(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i =2;i<=n;i++)
        {
            while (n%i==0){
                list.add(i);
                n=n/i;
                if(n==1)
                {
                    return list;
                }
            }
        }
        return list;
    }
    protected String toEqual(List<Integer> list){
        String s ="";
        if(list.size()==0)return s;
        s+=list.get(0);
        for(int i= 1;i<list.size();i++){
            s+=" * ";
            s+=list.get(i);
        }
        return s;
    }
}
class Main1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        //多组数据 需要用while（scan.hasNext())
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String factorEqul = n +" = ";
            Factors pr= new Factors();
            List<Integer> list =pr.getPrime(n);
            factorEqul += pr.toEqual(list);
            System.out.println(factorEqul);
        }
    }

}
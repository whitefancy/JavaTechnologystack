package leetcode.string;

import java.util.*;

public class NumPassword1 {
    // one !two !three !four !five !six !seven !eight  !nine zero
    public void unlock(String password){
        List<String> list = new ArrayList<>();
        for(int i =0;i<password.length();i++){
            String ch = (""+password.charAt(i)).toLowerCase();
            list.add(ch);
        }
        for(int i =0;i<list.size();i++){
            String ch = list.get(i);
            if(ch=="x"){
                list.remove("x");
            }
            list.add(ch);
        }
        System.out.println(list.get(list.size()-1));

    }
    public void test(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            unlock(s);
        }
    }
}

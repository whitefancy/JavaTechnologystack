package leetcode.collection;

import java.util.*;

public class FreqStack {
    List<Integer> stack;
    Map<Integer,Integer> map;
    public FreqStack() {
        stack = new LinkedList<>();
        map = new HashMap<>();
        //use -1 -=1 replace 1 to incre

    }

    public void push(int x) {
        stack.add(x);
//        if(map.containsKey(x))
//        {
//            map.put(x,map.get(x)+1);
//        }else
//        {
//            map.put(x,1);
//        }
        map.put(x,map.get(x)+1);
    }

    public int pop() {
        int max = 0;
        int key =0;
        int p = 0;
        for(int i =stack.size()-1;i>=0;i--){
            int val =stack.get(i);
            int count = map.get(val);
            if(count>max){
                max =count;
                key = val;
                p =i;
            }
        }
        map.put(key,map.get(key)-1);
        stack.remove(p);
        return key;
    }
}

package leetcode.collection;

import java.util.*;

public class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> group;
    int maxfreq;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
    }

    public void push(int x) {
        int f = freq.getOrDefault(x,0)+1;
        if(f>maxfreq){
            maxfreq=f;
        }
        freq.put(x,f);
        group.computeIfAbsent(f,z->new Stack<>()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x,freq.get(x)-1);
        if(group.get(maxfreq).size()==0){
            maxfreq--;
        }
        return x;
    }
}

package leetcode.collection;

import java.util.*;

public class SpecialEquivGroups {
//    你将得到一个字符串数组 A。
//
//    如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
//
//
//
//    一次移动包括选择两个索引 i 和 j，且 i％2 == j％2，并且交换 S[j] 和 S [i]。
//
//    现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
//
//
//
//    返回 A 中特殊等价字符串组的数量。
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new TreeSet<String>();
        for(int i =0;i<A.length;i++)
        {
            String s = A[i];
            List<Character> set1 =new ArrayList<Character>();
            List<Character> set2 =new ArrayList<Character>();
            for(int j =0;j<s.length();j++){
                if(j%2==0){
                    set1.add(s.charAt(j));
                }else {
                    set2.add(s.charAt(j));
                }
            }
            Collections.sort(set1);
            Collections.sort(set2);
            String se = set1.toString()+"#"+set2.toString();
            set.add(se);
        }
        return set.size();
    }
}

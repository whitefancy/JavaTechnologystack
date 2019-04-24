package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        LinkedList<Integer> vals = new LinkedList<Integer>();
        list.add(root);
        vals.add(root.val);
        while(!list.isEmpty()){
        	TreeNode cur =list.poll();
        	if(cur.val>min) {
        		vals.add( cur.val);
        	}
            if(cur.left!=null){
                if(cur.left.val<=cur.right.val)
                {
                    list.add(cur.left);
                    list.add(cur.right);
                }else {
                    list.add(cur.right);
                	list.add(cur.left);
                }
            }
        }
        Collections.sort(vals);
        for(Integer i :vals) {
        	if(i>min)return i;
        }
		return -1;
    }
}

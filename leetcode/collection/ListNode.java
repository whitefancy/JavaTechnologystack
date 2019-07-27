package leetcode.collection;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){val=x;}
    public static ListNode ListGen(String list){
        String[] vals = list.split("->");
        ListNode head=null;
        if(vals.length<2)return head;
        head = new ListNode(Integer.valueOf(vals[0]));
        ListNode cur = head;
        for (int i =1;i<vals.length-1;i++)
        {
            ListNode node = new ListNode(Integer.valueOf(vals[i]));
            cur.next=node;
            cur = node;
        }
        return head;
    }
    public static void ListOutput(ListNode head){
        if(head==null)System.out.println("NULL");
        else {
            System.out.print(head.val+"->");
            ListOutput(head.next);
        }
    }
}

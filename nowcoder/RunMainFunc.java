package nowcoder;

import java.util.ArrayList;
import java.util.List;

public class RunMainFunc {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Node> nei = new ArrayList<>();
        List<Node> nei1 = new ArrayList<>();
        Node node = new Node(1, nei);
        Node node1 = new Node(2, nei1);
        node.neighbors.add(node1);
        node1.neighbors.add(node);
        CloneGraph1 so = new CloneGraph1();
        Node out = so.cloneGraph(node);
        System.out.println(out.val);
    }
/*
 * 
 * public class Main {
	public static void main(String[] args) {
      
		Scanner sc = new Scanner(System.in);
		 List<String> answer= new ArrayList<String>();
        int n = sc.nextInt();
        for(int i =0;i<n;i++){
        	String s =sc.next();
        	String ans = bigNum(s);
        	answer.add(ans);
        	//System.out.println(ans);
        }
        for(int i =0;i<answer.size();i++){
        	String ans = answer.get(i);
        	System.out.println(ans);
        }
	}
	private static String bigNum(String s) {
		String bi = bigNum2Binary(s);
		String fi = binary5five(bi);
		//System.out.println(fi);
		 return fi;
	}
	private static String binary5five(String s) {
		// TODO Auto-generated method stub
	    List<String> FiveBinary= new ArrayList<String>();
		int st1_n = s.length()/5;
		int st1_y =s.length()%5;
		//System.out.println(s);
		if(st1_y!=0) {
			String sub = s.substring(0, st1_y);
			FiveBinary.add(sub);
			//System.out.println(sub);
		}
		for(int i =st1_y;i<s.length();i+=5) {

			String sub = s.substring(i, i+5);
			FiveBinary.add(sub);
			//System.out.println(sub);
		}
		String ans= "";
		for(int i=0;i<FiveBinary.size();i++)
		{
			String bi =FiveBinary.get(i);
			Integer a = Integer.parseInt(bi,2);
			//System.out.
			String fiv="";
			if(a<10)
			{
				fiv = a.toString();
			}else {
				int value =(int)'A'+a-10;
				char t = (char)value;
				fiv =String.valueOf(t); 
				//System.out.println(fiv);
			}
				
			ans+=fiv;
		}
		return ans;
	}
	private static String bigNum2Binary(String s) {
		// TODO Auto-generated method stub
	    List<Integer> ThreeBit = new ArrayList<Integer>();
	    String BinaryN = "";
		int st1_n = s.length()/3;
		int st1_y =s.length()%3;
		if(st1_y!=0) {
			String sub = s.substring(0, st1_y);
			int ele = Integer.parseInt(sub);
			ThreeBit.add(ele);
			//System.out.println(ele);
		}
		for(int i =st1_y;i<s.length();i+=3) {

			String sub = s.substring(i, i+3);
			int ele = Integer.parseInt(sub);
			ThreeBit.add(ele);
			//System.out.println(ele);
		}
		for(int i =0;i<ThreeBit.size();i++)
		{
			String bi = Integer.toBinaryString(ThreeBit.get(i));
			//System.out.println(bi);
			BinaryN+=bi;
			//System.out.println(BinaryN);
		}
		 
		return BinaryN;
	}
}*/
}

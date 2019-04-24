package utils.algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i =0;i<t;i++){
			int n = sc.nextInt();
			String s =sc.next();
			int ans =0;
	   		int[] G = new int[14];
        	for(int j =0;j<n*2-1;j+=2){
        		char c =s.charAt(j);
        		int num =0;
        		if(c=='J')num =11;
        		else if(c=='Q')num =12;
        		else if(c=='K')num =13;
        		else if(c=='A')num =1;
        		else
        			num=Integer.parseInt(String.valueOf(c));
            	G[num]++;
            	System.out.println(num);
            }
        	for(int j =0;j<14;j++){
        		if(G[j]>1) {
        			
        		}
            	//System.out.println(ans);
            }
        	System.out.println(ans);
        }
	}
	Map<Integer,Integer> nums = new HashMap<Integer,Integer>();
     /* 
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        n = sc.nextInt()+1;
        int m = sc.nextInt();
        int b = sc.nextInt();
        int e = sc.nextInt();
        for(int i =0;i<t;i++){
	   		List<Integer> Bans= new ArrayList<Integer>();
	   		int[][] G = new int[n][n];
        	for(int j =0;j<n;j++){
        		int ba = sc.nextInt();
            	Bans.add(ba);
            	//System.out.println(ans);
            }
        	for(int j =0;j<m;j++){
        		int x = sc.nextInt();
        		int y = sc.nextInt();
            	G[x][y]=1;
            	//System.out.println(ans);
            }
        	List<Double>answer = chongDian(Bans,G,b,e);
            for(int j =0;j<answer.size()-1;j++){
            	Double ans = answer.get(j);
            	System.out.print(String.format("%.4f", ans)+" ");
            }
            Double ans = answer.get(answer.size()-1);
            System.out.println(String.format("%.4f", ans));
        }
	}

	private static  List<Double> chongDian(List<Integer> bans, int[][] G, int b, int e) {
		// TODO Auto-generated method stub
		Double[] ans = new Double[n];
		Double startTime = new Double(0);
		Double flu=new Double(0);
		int need=0;
		int[] connactions = new int[n];
		ans[b] =b*1.0/e;
		for(int i =0;i<n;i++) {
			for(int j =0;j<n;j++)
			{
				if(G[i][j]==1) {
					connactions[i]+=1;
				}
			}
		}
		for(int i =0;i<n;i++) {
			if(G[b][i]==1) {
				flu = e*1.0/connactions[b];
				startTime +=ans[b];
				need =bans.get(i);
				ans[i]=caculationTime(startTime,flu,need);
			}
		}
		List<Double> answer = Arrays.asList(ans);
		answer.remove(0);
		return answer;
	}
	static Double caculationTime(double st,double flu,int need) {
		Double ans =st +need*1.0/flu;
		return ans;
	}
	*/
}
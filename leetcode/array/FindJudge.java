package leetcode.array;

public class FindJudge {
    public int findJudge(int N, int[][] trust) {
        int[][] list = new int[N+1][2];
        for(int i=0;i<trust.length;i++)
        {
            int p = trust[i][0];
            int x =trust[i][1];
            list[p][0]++;
            list[x][1]++;
        }
        int ans=0;
        int count=0;
        for(int i=1;i<list.length;i++){
            if(list[i][0]==0&&list[i][1]==N-1)
            {
                ans= i;
                count++;
            }
        }
        if(count==1)
        {
            return ans;
        }
        return -1;
    }
}

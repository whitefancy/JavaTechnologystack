package leetcode.array;

public class Main {
    public static void main(String[] args){
        FindJudge fj = new FindJudge();
        int N;
        int[][] trust = new int[][]{{1,3},{2,3},{3,1}};
        N = 3;
        int ans = fj.findJudge(N,trust);
        System.out.println(ans);
    }
}

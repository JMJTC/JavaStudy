package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-01
 * @Description: 3259. 超级饮料的最大强化能量
 * @Version: 1.0
 */
public class Problem3259 {
    public static void main(String[] args) {
        int[] a=new int[]{1,3,1};
        int[] b=new int[]{3,1,1};
        System.out.println(new Problem3259().maxEnergyBoost(a,b));
    }

    //dp
    public long maxEnergyBoost1(int[] a, int[] b){
        int n=a.length;
        long[][] dp=new long[n+2][2];
        for(int i=0;i<n;i++){
            dp[i+2][0]=Math.max(dp[i+1][0],dp[i][1])+a[i];
            dp[i+2][1]=Math.max(dp[i+1][1],dp[i][0])+b[i];
        }
        return Math.max(dp[n+1][0],dp[n+1][1]);
    }

    //记忆化搜索
    public long maxEnergyBoost(int[] a, int[] b){
        int n=a.length;
        long[][] memo=new long[n][2];
        int[][] c={a,b};
        return Math.max(dfs(n-1,0,c,memo),dfs(n-1,1,c,memo));
    }

    private long dfs(int i,int j,int[][] c,long[][] memo){
        if(i<0){
            return 0;
        }
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        return memo[i][j]=Math.max(dfs(i-1,j,c,memo),dfs(i-2,j^1,c,memo))+c[j][i];
    }
}

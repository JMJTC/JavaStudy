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

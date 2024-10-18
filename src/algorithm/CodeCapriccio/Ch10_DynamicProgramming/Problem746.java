package algorithm.CodeCapriccio.Ch10_DynamicProgramming;

/**
 * @author jmjtc
 */
public class Problem746 {
    public static void main(String[] args) {
        int[] cost=new int[]{1,100,1,1,1,100,1,1,100,1};
        new Problem746().minCostClimbingStairs(cost);
    }

    public int minCostClimbingStairs(int[] cost){
        int[] dp=new int[cost.length+1];
        //初始化
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
//        //打印dp
//        for (int j : dp) {
//            System.out.println(j);
//        }
        //还可优化一下空间复杂度
        //dp[i]只与前两个状态有关
        return dp[dp.length-1];
    }
}

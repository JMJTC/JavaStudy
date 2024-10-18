package algorithm.CodeCapriccio.Ch10_DynamicProgramming;

/**
 * @author jmjtc
 */
public class Problem70 {
    public static void main(String[] args) {

    }
    public int climbStairs(int n){
        // 动态规划
        // 1. 确定dp数组（dp table）以及下标的含义
        // 2. 确定递推公式
        // 3. dp数组如何初始化
        // 4. 确定遍历顺序
        // 5. 举例推导dp数组
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

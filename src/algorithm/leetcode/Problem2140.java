package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-01
 * @Description: 2140. 解决智力问题
 * @Version: 1.0
 */
public class Problem2140 {
    public static void main(String[] args) {

    }

    public long mostPoints(int[][] questions) {
        int length = questions.length;
        long[] dp = new long[length+1];
        //dp[i][j] 对于每题有选与不选 j = 0 选  j = 1 不选 ,从0-i题，可获得的最大分数
        //dp[i][0] = Math.max(dp[i-1][0]，dp[i-1][1])
        //dp[i][1] = Math.max(dp[i
        for (int i = length-1; i >= 0; i--){
            dp[i] = Math.max(dp[i+1], questions[i][0] + dp[Math.min(length, i + questions[i][1] + 1)]);
        }
        return dp[0];
    }
}

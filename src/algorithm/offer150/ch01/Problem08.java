package algorithm.offer150.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-05-05
 * @Description: 122. 买卖股票的最佳时机 II
 * @Version: 1.0
 */
public class Problem08 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        // 贪心
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i+1] > prices[i]){
                ans += prices[i+1] - prices[i];
            }
        }
        return ans;
    }

    //动态规划
    //dp[i][0] 卖第 i 天的股票的最大利润
    //dp[i][1] 买 i 天的股票的最大利润

    public int maxProfit1(int[] prices){
        int length = prices.length;
        int[][] dp = new int[length][2];
        if (length < 2){
            return 0;
        }
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }
}

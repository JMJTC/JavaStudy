package algorithm.offer150.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-31
 * @Description: 121. 买卖股票的最佳时机
 * @Version: 1.0
 */
public class Problem07 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int[] maxRight = new int[prices.length - 1];
        int tempMax = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            tempMax = Math.max(prices[i + 1], tempMax);
            maxRight[i] = tempMax;
        }
        for (int i = 0; i < prices.length - 1; i++) {
            ans = Math.max(maxRight[i] - prices[i], ans);
        }
        return ans;
    }
}

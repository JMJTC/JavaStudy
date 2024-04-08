package Algorithm.CodeCapriccio.Ch9_GreedyAlgorithm;

/**
 * @author jmjtc
 */
public class Problem122 {
    public static void main(String[] args) {

    }

    //贪心算法
    public int maxProfit(int[] prices){
        // 创建一个新的整型数组data，长度为prices.length-1，用来存储相邻日期价格的差值
        int[] data=new int[prices.length-1];

        // 计算相邻日期价格的差值，并存储在data数组中
        for(int i=1;i<prices.length;i++){
            data[i-1]=prices[i]-prices[i-1];
        }

        // 初始化一个变量ans为0，用来存储最终的最大收益
        int ans=0;

        // 遍历data数组，如果某一天的价格差值大于0，则将该差值加到ans中
        for (int datum : data) {
            if (datum > 0) {
                ans += datum;
            }
        }

        // 返回最终的最大收益ans
        return ans;
    }

    // 动态规划
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;//卖出
        dp[0][1] = -prices[0];//买入
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}

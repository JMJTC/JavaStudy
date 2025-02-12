package algorithm.acwing.p1;

import java.io.*;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-03
 * @Description: 2. 01背包问题
 * @Version: 1.0
 */
public class Problem02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int v = Integer.parseInt(s[1]);
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            weight[i] = Integer.parseInt(s[0]);
            value[i] = Integer.parseInt(s[1]);
        }
        //dp 二维
        // 定义一个二维数组dp，用于存储每个子问题的最优解
        int[][] dp = new int[n + 1][v + 1];
        // 遍历每个物品
        for (int i = 1; i <= n; i++) {
            // 遍历每个容量
            for (int j = 1; j <= v; j++) {
                // 如果当前容量大于等于物品的重量
                if (j >= weight[i]) {
                    // 则取放入物品和不放入物品的最大值
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
                } else {
                    // 否则，不放入物品
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        //dp 一维
        //定义一个数组f，长度为v+1，用于存储每个容量下的最大价值
        int[] f = new int[v + 1];
        //遍历每个物品
        for (int i = 1; i <= n; i++) {
            //从容量v开始，倒序遍历，确保每个物品只被考虑一次
            for (int j = v; j >= weight[i]; j--) {
                //更新f[j]，取当前容量下的最大价值
                f[j] = Math.max(f[j - weight[i]] + value[i], f[j]);
            }
        }


        bw.write(f[v] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

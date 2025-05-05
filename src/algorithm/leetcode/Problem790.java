package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-05-05
 * @Description: 790. 多米诺和托米诺平铺
 * @Version: 1.0
 */
public class Problem790 {
    public static void main(String[] args) {
       int ans = new Problem790().numTilings(10);
       System.out.println(ans);
    }

    public int numTilings(int n) {
        int mod = (int) 1e9 + 7;
        System.out.println(mod);
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % mod;
        }
        return dp[n][3];
    }

    private static final int MOD = 1_000_000_007;

    //找规律，多写几项
    public int numTilings1(int n) {
        if (n == 1) {
            return 1;
        }
        long[] f = new long[n + 1];
        f[0] = f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] * 2 + f[i - 3]) % MOD;
        }
        return (int) f[n];
    }
}

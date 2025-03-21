package algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-21
 * @Description: 2680. 最大或值
 * @Version: 1.0
 */
public class Problem2680 {
    public static void main(String[] args) {

    }

    //前缀后缀
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;

        // suf[i] 表示 nums[i+1] 到 nums[n-1] 的 OR
        int[] suf = new int[n];
        for(int i = n - 2; i >= 0; i--){
            suf[i] = suf[i + 1] | nums[i + 1];
        }

        long ans = 0;
        // pre 表示 nums[0] 到 nums[i-1] 的 OR
        int pre = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, pre | ((long) nums[i] << k) | suf[i]);
            pre |= nums[i];
        }
        return ans;

    }

    //空间优化
    public long maximumOr1(int[] nums, int k) {
        int allOr = 0;
        int fixed = 0;
        for (int x : nums) {
            // 如果在计算 allOr |= x 之前，allOr 和 x 有公共的 1
            // 那就意味着有多个 nums[i] 在这些比特位上都是 1
            fixed |= allOr & x; // 把公共的 1 记录到 fixed 中
            allOr |= x; // 所有数的 OR
        }

        long ans = 0;
        for (int x : nums) {
            ans = Math.max(ans, (allOr ^ x) | fixed | ((long) x << k));
        }
        return ans;
    }
}

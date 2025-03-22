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
        // 初始化一个数组 suf，用于存储从 i+1 到数组末尾的所有元素的按位或结果
        int[] suf = new int[n];
        // 从倒数第二个元素开始，向前遍历数组
        for(int i = n - 2; i >= 0; i--){
            // suf[i] 存储的是 nums[i+1] 到 nums[n-1] 的按位或结果
            suf[i] = suf[i + 1] | nums[i + 1];
        }

        long ans = 0;
        // pre 表示 nums[0] 到 nums[i-1] 的 OR
        // 初始化 pre 为 0，用于存储从数组开头到当前元素之前的所有元素的按位或结果
        int pre = 0;
        // 遍历数组 nums
        for(int i = 0; i < n; i++){
            // 计算当前元素 nums[i] 左移 k 位后的值，并与 pre 和 suf[i] 进行按位或操作
            // 更新 ans 为当前最大值
            ans = Math.max(ans, pre | ((long) nums[i] << k) | suf[i]);
            // 更新 pre，包含当前元素 nums[i] 的按位或结果
            pre |= nums[i];
        }
        // 返回最终计算的最大按位或结果
        return ans;
    }

    //空间优化
    public long maximumOr1(int[] nums, int k) {
        int allOr = 0; // 用于存储所有数的按位或结果
        int fixed = 0; // 用于存储所有数中公共的1位
        for (int x : nums) {
            // 如果在计算 allOr |= x 之前，allOr 和 x 有公共的 1
            // 那就意味着有多个 nums[i] 在这些比特位上都是 1
            fixed |= allOr & x; // 把公共的 1 记录到 fixed 中
            allOr |= x; // 所有数的 OR
        }

        long ans = 0; // 用于存储最终结果
        for (int x : nums) {
            // 计算当前数 x 与 allOr 的异或结果
            // 然后与 fixed 进行按位或
            // 最后将 x 左移 k 位后与上述结果进行按位或
            ans = Math.max(ans, (allOr ^ x) | fixed | ((long) x << k));
        }
        return ans; // 返回最终结果
    }
}

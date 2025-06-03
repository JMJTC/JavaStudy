package algorithm.offer150.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-03
 * @Description: 238. 除自身以外数组的乘积
 * @Version: 1.0
 */
public class Problem13 {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        // 前后缀
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        pre[0] = 1;
        post[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }

    // 优化空间复杂度
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        int pre = 1;
        for (int i = 0; i < n; i++) {
            // 此时 pre 为 nums[0] 到 nums[i-1] 的乘积，直接乘到 suf[i] 中
            suf[i] *= pre;
            pre *= nums[i];
        }

        return suf;
    }
}

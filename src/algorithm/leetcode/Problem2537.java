package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-16
 * @Description: 2537. 统计好子数组的数目
 * @Version: 1.0
 */
public class Problem2537 {
    public static void main(String[] args) {

    }

    public long countGood(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            hash.put(nums[right], hash.getOrDefault(nums[right], 0) + 1);
            count += hash.get(nums[right]) - 1; // Increment count by the number of new pairs formed with the current element

            while (count >= k) {
                ans += nums.length - right; // All subarrays starting from left to right are good
                count -= hash.get(nums[left]) - 1; // Decrement count by the number of pairs removed with the current element
                hash.put(nums[left], hash.get(nums[left]) - 1);
                left++;
            }
        }

        return ans;
    }
}

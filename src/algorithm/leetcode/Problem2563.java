package algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-19
 * @Description: 2563. 统计公平数对的数目
 * @Version: 1.0
 */
public class Problem2563 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,7,4,4,5};
        new Problem2563().countFairPairs(nums, 3, 6);
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            int min = lower - nums[i];
            int max = upper - nums[i];
            if (min > nums[nums.length - 1] || max < nums[i + 1]){
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int mid = (l + r) >> 1;
                if (nums[mid] > min){
                    r  = mid;
                }
                if (nums[mid] < min){
                    l = mid + 1;
                }
                if (nums[mid] == min){
                    l = mid;
                }
            }
            int left = l;
            l = i + 1;
            r = nums.length - 1;
            while (l < r){
                int mid = (l + r) >> 1;
                if (nums[mid] > max){
                    r  = mid - 1;
                }
                if (nums[mid] < max){
                    l = mid + 1;
                }
                if (nums[mid] == max){
                    l = mid;
                }
            }
            int right = l;
            ans += right - left + 1;
        }
        return ans;
    }
}

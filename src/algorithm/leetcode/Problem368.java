package algorithm.leetcode;

import algorithm.contestlan.guo13.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-06
 * @Description: 368. 最大整除子集
 * @Version: 1.0
 */
public class Problem368 {
    private List<Integer> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 8};
        new Problem368().largestDivisibleSubset(nums);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (ans.contains(nums[i])) {
                continue;
            }
            temp.clear();
            temp.add(nums[i]);
            backTracking(nums, i);
        }
        return ans;
    }

    private void backTracking(int[] nums, int index) {
        if (temp.size() > ans.size()) {
            ans = new ArrayList<>(temp);
        }
        if (index == nums.length) {
            return;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] % nums[index] == 0 && !ans.contains(nums[i])) {
                temp.add(nums[i]);
                backTracking(nums, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

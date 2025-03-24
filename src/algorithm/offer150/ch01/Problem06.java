package algorithm.offer150.ch01;

import java.util.Arrays;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-24
 * @Description: 189. 轮转数组 <a href="https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @Version: 1.0
 */
public class Problem06 {
    public static void main(String[] args) {
        String str = "jmjtc";
        System.out.println(new StringBuilder(str).reverse());
    }

    public void rotate(int[] nums, int k) {
        int[] cpyNums = Arrays.copyOf(nums, nums.length);
//        int temp = nums[0];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = cpyNums[i];
        }
    }

    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, length-1);
    }

    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

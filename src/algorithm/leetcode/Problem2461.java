package algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-06
 * @Description: 2461. 长度为 K 子数组中的最大和
 * @Version: 1.0
 */
public class Problem2461 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 7, 8, 9};
        System.out.print(new Problem2461().maximumSubarraySum(nums, 3));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long temp = 0;
        int n = nums.length;
        int count=0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
            temp+=nums[i];
            count++;
            if(count==k){
                count--;
                if(hash.size()==k){
                    if(ans<temp){
                        ans=temp;
                    }
                }
                if(hash.get(nums[i-k+1])<=1){
                    hash.remove(nums[i-k+1]);
                }else{
                    hash.put(nums[i-k+1],hash.get(nums[i-k+1])-1);
                }
                temp-=nums[i-k+1];
            }
        }
        return ans;
    }
}

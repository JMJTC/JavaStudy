package algorithm.CodeCapriccio.Ch9_GreedyAlgorithm;

import java.util.Arrays;

/**
 * @author jmjtc
 * 力扣题目链接：<a href="https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/">...</a>
 */
public class Problem1005 {
    public static void main(String[] args) {
        new Problem1005().largestSumAfterKNegations(new int[]{3,-1,0,2}, 3);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int ans=0;
        Arrays.sort(nums);
        for (int num : nums) {
            ans += num;
        }
        int index=0;
        while (k>0) {
            if(index<nums.length && nums[index]<0){
                nums[index]=-nums[index];
                ans+=2*nums[index];
                k--;
                index++;
            }else{
                Arrays.sort(nums);
                if(k%2==1){
                    ans-=2*nums[0];
                }
                break;
            }
        }
        return ans;
    }
}

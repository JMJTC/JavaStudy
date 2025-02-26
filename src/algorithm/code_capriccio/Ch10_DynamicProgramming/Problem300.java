package algorithm.code_capriccio.Ch10_DynamicProgramming;

import java.util.Arrays;

public class Problem300 {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums){
        int[] dp=new int[nums.length];
        int res=1;
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                res=Math.max(dp[i],res);
            }
        }
        return res;
    }
}

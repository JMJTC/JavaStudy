package Algorithm.CodeCapriccio.Ch10_DynamicProgramming;

import java.util.Arrays;

public class Problem674 {
    public static void main(String[] args) {

    }

    public int findLengthOfLCIS(int[] nums){
        int res=0;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=Math.max(dp[i],dp[i-1]+1);
            }
            res=Math.max(dp[i],res);
        }
        return res;
    }
}

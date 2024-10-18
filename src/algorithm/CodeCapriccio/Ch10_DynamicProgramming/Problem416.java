package algorithm.CodeCapriccio.Ch10_DynamicProgramming;

import java.util.Arrays;

/**
 * @author jmjtc
 */
public class Problem416 {
    public static void main(String[] args) {
        System.out.print(new Problem416().canPartition1(new int[]{1,2,5}));
    }

    //动态规划
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        sum/=2;
        int[] dp=new int[sum+1];
        for(int i=0;i< nums.length;i++){
            for(int j=sum;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[sum] == sum;

        /*
        二维写法
        int[][] dp=new int[nums.length][sum+1];
        //初始化
        for(int i=0;i<nums.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<sum;i++){
            if(nums[0]<=i){
                dp[0][i]=nums[0];
            }else{
                dp[0][1]=0;
            }
        }

        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][sum]==sum;
         */

    }

    //回溯 超时
    public boolean canPartition1(int[] nums){
        //对nums求和
         sum=Arrays.stream(nums).sum();
        if(sum%2!=0){
            return false;
        }
        sum/=2;
        backTracking(nums,0,sum);
        return flag;
    }
    public boolean flag=false;
    public int sum;
    public void backTracking(int[] nums,int index, int sum){
        if(sum==0){
            flag=true;
            return;
        }

        for(int i=index;i<nums.length;i++){
            sum-=nums[i];
            backTracking(nums,i+1,sum);
            //回溯
            sum+=nums[i];
        }
    }
}

package algorithm.CodeCapriccio.Ch10_DynamicProgramming;

import java.util.Arrays;

/**
 * @author jmjtc
 */
public class Problem494 {

    int ans=0;
    public static void main(String[] args) {

    }

    //回溯
    public int findTargetSumWays(int[] nums, int target) {

        Arrays.sort(nums);
        int sum= Arrays.stream(nums).sum();
        if(sum<target){
            return ans;
        }
        backTracking(nums,target,0,sum);
        return ans;
    }
    public void backTracking(int[] nums,int target,int start,int sum){
        if(sum==target){
            ans++;
            //return;  这里不能return ???why  测试用例[0,1]  think
        }
        //剪枝
        if(sum<target){
            return;
        }
        for(int i=start;i<nums.length;i++){
            sum=sum-(2*nums[i]);
            backTracking(nums,target,i+1,sum);
            //回溯
            sum=sum+(2*nums[i]);
        }
    }


    //方二 dp
    public int findTargetSumWays2(int[] nums, int target) {
        int sum=Arrays.stream(nums).sum();

        if(Math.abs(target)>sum){
            return 0;
        }

        if((target+sum)%2==1){
            return 0;
        }

        int bagSize=(target+sum)/2;
        int[] dp=new int[bagSize+1];
        dp[0]=1;

        for (int num : nums) {
            for (int j = bagSize; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[bagSize];
    }
}

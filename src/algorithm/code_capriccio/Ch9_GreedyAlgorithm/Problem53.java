package algorithm.code_capriccio.Ch9_GreedyAlgorithm;

public class Problem53 {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        int ans=-100000;
        //暴力
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                int temp=0;
                for(int k=i;k<=j;k++){
                    temp+=nums[k];
                    if(temp>ans){
                        ans=temp;
                    }
                }
            }
        }
        return ans;
    }
    //贪心
    public int maxSubArray1(int[] nums){
        int ans=-100000;
        int count=0;
        for (int num : nums) {
            count += num;
            if (count < 0) {
                count = 0;
            }
            if (count > ans) {
                ans = count;
            }
        }
        return ans;
    }

    //动态规划
    public int maxSubArray2(int[] nums){
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        int ans=dp[0];
        for(int i=1;i<nums.length;i++){

            if(ans<dp[i]){
                ans=dp[i];
            }
        }
        return ans;
    }
}

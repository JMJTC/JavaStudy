package algorithm.code_capriccio.Ch9_GreedyAlgorithm;

/**
 * @author jmjtc
 * <a href="https://leetcode.cn/problems/wiggle-subsequence/description/">...</a>
 * 摆动序列
 */
public class Problem376 {
    public static void main(String[] args) {
        int[] test=new int[]{3,3,3,2,5};
        new Problem376().wiggleMaxLength(test);
    }


    //贪心,时间复杂度:O(n)
    public int wiggleMaxLength(int[] nums){
        if(nums.length<2){
            return nums.length;
        }
        int[] flag=new int[nums.length-1];//记录正负
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]>nums[i]){
                flag[i]=1;
            }else if(nums[i+1]==nums[i]){
                flag[i]=999;
            }else{
                flag[i]=-1;
            }
        }

        int ans=0;
        int temp=0;
        while(temp<flag.length-1&&flag[temp]==999){
            temp++;
        }
        for(int i=1;i<flag.length;i++){
            if(flag[temp]+flag[i]==0){
                ans++;
                temp=i;
            }
        }
        if(ans==0){
            for (int j : flag) {
                if (j != 999) {
                    return 2;
                }
            }
            return 1;
        }
        return ans+2;
    }

    //方二，动态规划
    public int wiggleMaxLength1(int[] nums){
        int[][] dp=new int[nums.length][2];
        dp[0][0]=1;dp[0][1]=1;//0做山峰，1做山谷
        for(int i=1;i<nums.length;i++){
            dp[i][0]=1;dp[i][1]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i][0]=Math.max(dp[i][0],dp[j][1]+1);
                }
            }
            for(int j=0;j<i;j++){
                //如果nums[i]<nums[j]，则nums[i]为山谷
                if(nums[i]<nums[j]){
                    dp[i][1]=Math.max(dp[i][1],dp[j][0]+1);
                }
            }
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}

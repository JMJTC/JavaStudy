package algorithm.CodeCapriccio.Ch10_DynamicProgramming;

import java.util.Arrays;

/**
 * @author jmjtc
 */
public class Problem1049 {
    public static void main(String[] args) {
        System.out.print(new Problem1049().lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }

    //动态规划
    public int lastStoneWeightII(int[] stones) {
        int sum= Arrays.stream(stones).sum();
        int[] dp=new int[sum/2+1];
        for(int i=0;i<stones.length;i++){
            for(int j=dp.length-1;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        int ans=sum-2*dp[dp.length-1];
        return ans>=0?ans:-ans;
    }
}

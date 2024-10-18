package algorithm.CodeCapriccio.Ch10_DynamicProgramming;

/**
 * @author jmjtc
 */
public class Problem343 {
    public static void main(String[] args) {
        new Problem343().integerBreak(10);
    }

   public int integerBreak(int n){
        //int ans=0;
        //定义一个动态规划数组，用于存储从0到n的整数能够得到的乘积最大值
        int[] dp=new int[n+1];
        //初始化动态规划数组
        dp[0]=0;dp[1]=1;
        //遍历从2到n的整数
        for(int i=2;i<=n;i++){
            //遍历从1到i/2的整数
            for(int j=1;j<=i/2;j++){
                //更新动态规划数组，取当前的最大值
                dp[i]=Math.max(dp[i],Math.max(dp[j],j)*Math.max(i-j,dp[i-j]));
            }
        }
        //返回动态规划数组中n对应的值，即整数n能够得到的乘积最大值
        return dp[n];
    }
}

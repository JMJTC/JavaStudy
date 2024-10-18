package algorithm.CodeCapriccio.Ch10_DynamicProgramming;

/**
 * @author jmjtc
 */
public class Problem96 {
    public static void main(String[] args) {

    }

    public int numTrees(int n){
        //定义一个动态规划数组，用来存储从0到当前下标的树的个数
        int[] dp=new int[n+1];
        //当n为0时，一棵树也没有
        dp[0]=1;
        //当n为1时，一棵树也没有
        dp[1]=1;
        //从2开始，到n结束
        for(int i=2;i<=n;i++){
            //遍历当前下标的所有可能
            for(int j=1;j<=i;j++){
                //动态规划方程：dp[i] += dp[j-1] * dp[i-j]
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        //返回从0到当前下标的树的个数
        return dp[n];
    }
}

package Algorithm.CodeCapriccio.Ch10_DynamicProgramming;

public class Problem62 {
    public static void main(String[] args) {

    }

   public int uniquePaths(int m, int n){
        int[][] dp=new int[m][n];
        //dp数组初始化
        for(int i=0;i<m;i++){
            dp[i][0]=1;//第一列初始化
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;//第一行初始化
        }
        //dp[i][j]=dp[i-1][j]+dp[i][j-1]
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];//返回最终结果
    }
}

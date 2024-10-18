package algorithm.CodeCapriccio.Ch10_DynamicProgramming;

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

    //组合数的计算方法
    public int uniquePaths1(int m, int n) {
        // 计算 C(m-1, n-1)
        long ans = 1;
        // 优化空间，使用两个变量分别记录 x 和 y
        for (int x = n, y = 1; y < m; ++x, ++y) {
            // 计算 ans * x / y，同时保持 ans 的结果为整数
            ans = ans * x / y;
        }
        // 返回计算结果，注意强转为 int 类型
        return (int) ans;
    }


}

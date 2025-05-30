package algorithm.code_capriccio.Ch10_DynamicProgramming;

/**
 * @author jmjtc
 */
public class Problem63 {
    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        //初始化
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        //初始化时考虑要全面
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    if(i==0){
                        for(int k=j;k<n;k++){
                            dp[i][k]=0;
                        }
                    }
                    if(j==0){
                        for(int k=i;k<m;k++){
                            dp[k][j]=0;
                        }
                    }
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}

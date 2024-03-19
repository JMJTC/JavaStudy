package Algorithm.CodeCapriccio.Ch10_DynamicProgramming;


import java.util.Scanner;

/**
 * @author jmjtc
 */
public class KamaCoder46 {
    private static int m,n;//m种类，n空间
    private static int[] weight;
    private static int[] values;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        input(sc);
        System.out.print(getMaxValue1());
    }

    public static int getMaxValue(){
        int[][] dp=new int[m][n+1];
        //初始化dp数组
        for(int i=0;i<m;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=n;i++){
            if(i<weight[0]){
                dp[0][i]=0;
            }else{
                dp[0][i]=values[0];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<=n;j++){
                if(j>=weight[i]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+values[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m-1][n];
    }

    //一维dp数组
    public static int getMaxValue1(){
        int[] dp=new int[n+1];
        //将dp初始化为0
        for(int i=0;i<=n;i++){
            dp[i]=0;
        }
        for(int i=0;i<m;i++){
            for(int j=n;j>=weight[i];j--){//好好想想这里为什么需要倒序遍历
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+values[i]);
            }
        }
        return dp[n];
    }
    public static void input(Scanner sc){
        m=sc.nextInt();n=sc.nextInt();
        weight=new int[m];
        values=new int[m];
        for(int i=0;i<m;i++){
            weight[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++){
            values[i]=sc.nextInt();
        }
    }


}

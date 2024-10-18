package algorithm.EveryWeekStudy.week3;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week3_6 {
    public static final int MAX =1000000007;
    //思路：先用递归分析，但递归时重复计算太多，会超出时间限制，改为for循环，记忆化数组
    // f(n,k)
    // 1.n<k 比n大的k值无意义 f(n,k)=f(n,n)
    // 2.n=k f(n,k)=1+f(n,k-1)
    // 3.n>k 分为：拆分方案至少包含一个k f(n-k,k)；不包含k,f(n,k-1)；
    // =>f(n,k)=f(n-k,k)+f(n,k-1)
    // 边界条件：f(n,1)=1,f(1,k)=1,
    public static int numberOfPartitions(int n,int k){
//        if(n==1||k==1){
//            return 1;
//        }
//        if(n<k){
//            return numberOfPartitions(n,n);
//        }
//        else if(n==k){
//            return (1+numberOfPartitions(n,k-1))%MAX;
//        }
//        else{
//            return numberOfPartitions(n-k,k)+numberOfPartitions(n,k-1);
//        }
        k=Math.min(n,k);
        int[][]dp=new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(i==1||j==1){
                    dp[i][j]=1;
                }
                else if(i==j){
                    dp[i][j]=(1+dp[i][j-1])%MAX;
                }
                else if(i>j){
                    dp[i][j]=(dp[i-j][j]+dp[i][j-1])%MAX;
                }
                else{
                    dp[i][j]=dp[i][i];
                }
            }
        }
        return dp[n][k];
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),k=in.nextInt();
        System.out.println(numberOfPartitions(n,k));
    }
}

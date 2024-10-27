package algorithm.contestlan._14th;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class E_Snail {
    private static int n;
    private static int[] x;
    private static int[] a,b;
    private static final double UP=0.7;
    private static final double DOWN=1.3;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        x=new int[n];

        for(int i=0;i<n;i++){
            x[i]=sc.nextInt();
        }
        if(n==1){
            System.out.printf("%.2f",(double)x[0]);
            return;
        }

        a=new int[n-1];
        b=new int[n-1];
        for(int i=0;i<n-1;i++){
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
        }

        //动态规划
        double[][] dp=new double[n+1][2];
        //初始化
        dp[0][0]=0;dp[0][1]=0;
        dp[1][0]=x[0];dp[1][1]=x[0]+a[0]/UP;
        for(int i=2;i<=n;i++){
            dp[i][0]=Math.min(dp[i-1][0]+x[i-1]-x[i-2],dp[i-1][1]+b[i-2]/DOWN);
            if(i<n){
                dp[i][1]=Math.min(dp[i][0]+a[i-1]/UP,dp[i-1][1]+((a[i-1]-b[i-2])>0?(a[i-1]-b[i-2])/UP:(b[i-2]-a[i-1])/DOWN));
            }
        }
        System.out.printf("%.2f",dp[n][0]);
    }
}

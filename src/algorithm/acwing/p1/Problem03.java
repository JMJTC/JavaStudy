package algorithm.acwing.p1;

import java.io.*;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-21
 * @Description: 3. 完全背包问题
 * @Version: 1.0
 */
public class Problem03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int v=Integer.parseInt(s[1]);
        int[] weight=new int[n+1];
        int[] value=new int[n+1];
        for(int i=1;i<=n;i++){
            s=br.readLine().split(" ");
            weight[i]=Integer.parseInt(s[0]);
            value[i]=Integer.parseInt(s[1]);
        }
        int[][] dp=new int[n+1][v+1];
        //时间复杂度太高，接近O(n^3)
        for(int i=1;i<=n;i++){
            for(int j=1;j<=v;j++){
                dp[i][j]=dp[i-1][j];
                int count=1;
                while(j>=weight[i]*count){
                    dp[i][j]=Math.max(dp[i-1][j-weight[i]*count]+value[i]*count,dp[i][j]);
                    count++;
                }
            }
        }

        //优化
        int[][] dp1=new int[n+1][v+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=v;j++){
                dp1[i][j]=dp1[i-1][j];
                if(j>=weight[i]){
                    dp1[i][j]=Math.max(dp1[i-1][j],dp1[i][j-weight[i]]+value[i]);
                }
            }
        }

        //优化成一维
        int[] dp3=new int[v+1];
        for(int i=1;i<=n;i++){
            for(int j=weight[i];j<=v;j++){
                dp3[j]=Math.max(dp3[j],dp3[j-weight[i]]+value[i]);
            }
        }

        bw.write(dp3[v]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

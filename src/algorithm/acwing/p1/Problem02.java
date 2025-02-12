package algorithm.acwing.p1;

import java.io.*;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-03
 * @Description: 2. 01背包问题
 * @Version: 1.0
 */
public class Problem02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int v=Integer.parseInt(s[1]);
        int[] weight=new int[n+1];
        int[] value=new int[n+1];
        for (int i = 1; i <= n; i++) {
            s=br.readLine().split(" ");
            weight[i]=Integer.parseInt(s[0]);
            value[i]=Integer.parseInt(s[1]);
        }
        //dp
        int[][] dp=new int[n+1][v+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=v;j++){
                if(j>=weight[i]){
                    dp[i][j]=Math.max(dp[i-1][j-weight[i]]+value[i],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        bw.write(dp[n][n]+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

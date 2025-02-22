package algorithm.acwing.p1;

import java.io.*;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-22
 * @Description: 多重背包I
 * @Version: 1.0
 */
public class Problem04 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N=Integer.parseInt(str[0]);
        int V=Integer.parseInt(str[1]);
        int[] v=new int[N+1];
        int[] w=new int[N+1];
        int[] s=new int[N+1];
        for(int i=1;i<=N;i++){
            str=br.readLine().split(" ");
            v[i]=Integer.parseInt(str[0]);
            w[i]=Integer.parseInt(str[1]);
            s[i]=Integer.parseInt(str[2]);
        }

        int[][] dp=new int[N+1][V+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=V;j++){
                dp[i][j]=dp[i-1][j];
                for(int k=1;k<=s[i];k++){
                    if(j>=k*v[i]){
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][j-k*v[i]]+w[i]*k);
                    }
                }
            }
        }

        int[] dp1=new int[V+1];
        for(int i=1;i<=N;i++){
            for(int j=V;j>=1;j--){
                for(int k=1;k<=s[i]&&k*v[i]<=j;k++){
                    dp1[j]=Math.max(dp1[j],dp1[j-k*v[i]]+k*w[i]);
                }
            }
        }
        bw.write(dp1[V]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

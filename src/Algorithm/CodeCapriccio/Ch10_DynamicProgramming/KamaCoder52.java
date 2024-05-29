package Algorithm.CodeCapriccio.Ch10_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class KamaCoder52 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer=new PrintWriter(System.out);

        String[] str=reader.readLine().split(" ");
        int n=Integer.parseInt(str[0]);//种类
        int m=Integer.parseInt(str[1]);//空间

        int[] v=new int[n+1];//价值
        int[] w=new int[n+1];//重量
        for(int i=1;i<=n;i++){
            str=reader.readLine().split(" ");
            v[i]=Integer.parseInt(str[0]);
            w[i]=Integer.parseInt(str[1]);
        }

        int [][]dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(w[i]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]+v[i]]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        writer.println(dp[n][m]);
        writer.flush();
    }
}

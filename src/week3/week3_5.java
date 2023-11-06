package week3;

import java.util.Scanner;

/**
 * @author jmjtc
 */

public class week3_5 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        //n为物品数量，v为背包体积
        int n =in.nextInt(), v =in.nextInt();
        //分别第 i 件物品的体积和价值
        int[][] item=new int[n][2];
        for(int i=0;i<n;i++){
            item[i][0]=in.nextInt();
            item[i][1]=in.nextInt();
        }
        //初始化dp数组,这个部分还需要反复理解
        int[][] dp=new int[n][v+1];
        for(int i=item[0][0];i<v;i++){
            dp[0][i]=item[0][1];
        }
        //遍历物品，再遍历背包
        for(int i=1;i<n;i++){//i=1是因为物品0在初始化时已经遍历过了
            for(int j=0;j<=v;j++){
                if(j<item[i][0]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]= Math.max(dp[i - 1][j], (dp[i - 1][j - item[i][0]] + item[i][1]));
                }
            }
        }
        System.out.println(dp[n-1][v]);
    }
}

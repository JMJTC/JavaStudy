package week3;

import java.util.Scanner;

/**
 * @author jmjtc
 */
//编辑距离
public class week3_7 {
    //定义一个二维dp数组dp[i][j],为以下标i-1结尾的word1，j-1下标结尾的word2 最近编辑距离
    //dp[0][0]?,遍历的时候i,j都是从1开始的
    //if(word[i-1]==word[j-1]) 不需要任何操作，dp[i][j]=dp[i-1][j-1]
    //if(word[i-1]!=word[j-1]) 增?删?换?,
    // word2增加一个元素可以的等价于word1删除一个元素，所以增删的操作可以统一
    //换的话就是使两个元素相等，只需要一步操作，也就是dp[i][j]=dp[i-1][j-1]+1
    // 故dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1)
    //dp数组初始化，先找出这个递推公式的推导方向，再判断该如何初始化
    //dp[i][0],相当于word[i-1]=>空字符串，只需要删除操作，即dp[i][0]=i;dp[0][j]同理
    public static int minDistance(String word1,String word2){
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        //初始化dp
        for(int i=0;i<=word1.length();i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=word2.length();j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String word1=sc.next();
        String word2=sc.next();
        System.out.println(minDistance(word1,word2));
    }
}

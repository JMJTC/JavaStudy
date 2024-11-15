package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-15
 * @Description: 3239. 最少翻转次数使二进制矩阵回文 I
 * @Version: 1.0
 */
public class Problem3239 {
    public static void main(String[] args) {

    }
    public int minFlips(int[][] grid) {
        int ans1=0;
        int ans2=0;
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col/2;j++){
                if(grid[i][j]!=grid[i][col-j-1]){
                    ans1++;
                }
            }
        }
        for(int i=0;i<col;i++){
            for(int j=0;j<row/2;j++){
                if(grid[j][i]!=grid[row-j-1][i]){
                    ans2++;
                }
            }
        }

        return ans1>ans2?ans2:ans1;
    }
}

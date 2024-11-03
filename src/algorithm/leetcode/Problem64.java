package algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-01
 * @Description: 最小路径和
 * @Version: 1.0
 */
public class Problem64 {
    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Problem64().minPathSum(grid));
    }

    //记忆化搜索
    private int M;
    private int N;
    private int[][] memo;
    public int minPathSum(int[][] grid) {
        M=grid.length;
        N=grid[0].length;
        memo=new int[M][N];
        for(int i=0;i<M;i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(grid,0,0);
    }

    private int dfs(int[][] grid,int r,int c){
        //越界
        if(r<0||r>=M||c<0||c>=N){
            return Integer.MAX_VALUE;
        }
        if(memo[r][c]>-1){
            return memo[r][c];
        }
        //到达终点
        if(r==M-1&&c==N-1){
            return grid[M-1][N-1];
        }
        //右边
        int right=dfs(grid,r,c+1);
        //下
        int down=dfs(grid,r+1,c);
        int ans=Math.min(right,down)+grid[r][c];
        memo[r][c]=ans;
        return ans;
    }

    //dp
    public int minPathSum1(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>0&&j>0){
                    grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }else if(i==0){
                    if(j!=0){
                        grid[i][j]=grid[i][j-1]+grid[i][j];
                    }
                }else{
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                }
            }
        }
        return grid[n-1][m-1];
    }
}

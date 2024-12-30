package algorithm.leetcode.contestweek146;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-12-21
 * @Description: Q2. 统计异或值为给定值的路径数目
 * @Version: 1.0
 */
public class Q2 {
    private int[][] direct=new int[][]{{1,0},{0,1}};
    private int count=0;
    public int countPathsWithXorValue(int[][] grid, int k) {
        int mod= (int) (1e9+7);
        int m=grid.length,n=grid[0].length;
        backtrack(grid,k,0,0,grid[0][0],mod);
        return count;
    }
    private void backtrack(int[][] grid,int k,int i,int j,int sum,int mod){
        if(i==grid.length-1&&j==grid[0].length-1){
            if(sum==k){
                count++;
                count%=mod;
            }
            return;
        }
        for(int[] d:direct){
            int x=i+d[0],y=j+d[1];
            if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length){
                backtrack(grid,k,x,y,sum^grid[x][y],mod);
            }
        }
    }
}

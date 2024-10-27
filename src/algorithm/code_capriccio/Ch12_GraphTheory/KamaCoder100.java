package algorithm.code_capriccio.Ch12_GraphTheory;

import java.util.Scanner;

/**
 * @author jmjtc
 * <a href="https://kamacoder.com/problempage.php?pid=1172">岛屿的最大面积</a>
 */
public class KamaCoder100 {
    private static boolean[][] visited;
    private static int maxArea = 0;
    private static int tempArea = 0;
    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] grid=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        visited=new boolean[n][m];
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    tempArea=1;
                    dfs(grid,i,j);
                    if(tempArea>maxArea){
                        maxArea=tempArea;
                    }
                }
            }
        }
        return maxArea;
    }

    private static void dfs(int[][] grid,int x,int y){
        visited[x][y]=true;
        //四个方向
        for(int[] dir:dirs){
            int newX=x+dir[0];
            int newY=y+dir[1];
            if(newX>=0&&newX<grid.length
                    &&newY>=0 &&newY<grid[0].length
                    &&grid[newX][newY]==1 &&!visited[newX][newY]){
                tempArea++;
                dfs(grid,newX,newY);
            }
        }
    }
}

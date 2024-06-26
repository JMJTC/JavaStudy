package Algorithm.CodeCapriccio.Ch12_GraphTheory;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author jmjtc
 * <a href="https://kamacoder.com/problempage.php?pid=1171">...</a>
 */
public class KamaCoder99 {
    public static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] data=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                data[i][j]=sc.nextInt();
            }
        }
        int ans=0;
        visited=new boolean[data.length][data[0].length];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&data[i][j]==1){
                    dfs(data,i,j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void bfs(int[][] data,int x,int y){
        visited[x][y]=true;
        //定义4个方向
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        Deque<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            //遍历四个方向
            for(int[] dir:directions){
                int newX=cur[0]+dir[0];
                int newY=cur[1]+dir[1];
                if(newX>=0&&newX<data.length&&newY>=0&&newY<data[0].length&&!visited[newX][newY]&&data[newX][newY]==1){
                    queue.offer(new int[]{newX,newY});
                    visited[newX][newY]=true;
                }
            }
        }
    }

    public static void dfs(int[][] data,int x,int y){
        visited[x][y]=true;
        //定义4个方向
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:directions){
            int newX=x+dir[0];
            int newY=y+dir[1];
            if(newX>=0&&newX<data.length&&newY>=0&&newY<data[0].length&&!visited[newX][newY]&&data[newX][newY]==1){
                dfs(data,newX,newY);
            }
        }
    }
}

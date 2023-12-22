package Algorithm.EveryWeekStudy.week6;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week6_4 {
    private int row,col;
    private Deque<int[]> path;
    private Deque<int[]> tempPath=new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        new week6_4().main(sc);
    }
    public void main(Scanner sc){
        row=sc.nextInt();
        col=sc.nextInt();
        int[][] arr=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        path=new LinkedList<>();
        dfs(arr,0,0);
        while(!path.isEmpty()){
            int[] pth=path.poll();
            System.out.println("("+pth[0]+","+pth[1]+")");
        }
    }
    public void dfs(int[][] arr,int i,int j){

        if(i==row-1&&j==col-1){
            tempPath.offer(new int[]{i,j});
            path.addAll(tempPath);
            return;
        }
        if(arr[i][j]!=1){
            //标记已走
            arr[i][j]=1;
            tempPath.offer(new int[]{i,j});
            //下
            if(i<row-1){
                dfs(arr,i+1,j);
            }
            //右
            if(j<col-1){
                dfs(arr,i,j+1);
            }
            //上
            if(i>0){
                dfs(arr,i-1,j);
            }
            //左
            if(j>0){
                dfs(arr,i,j-1);
            }
            tempPath.pollLast();
        }
    }
}

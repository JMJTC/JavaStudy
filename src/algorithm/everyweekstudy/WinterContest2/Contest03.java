package algorithm.everyweekstudy.WinterContest2;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest03 {
    public static int n;
    public static int[] ans;
    public static boolean judge=false;
    public static void eightQueensPuzzle(int row,boolean[][] flag,int choose){
        for(int i=0;i<n;i++){
            flag[row][i]=true;//所在的行
            flag[i][choose]=true;//所在的列
            if(row+i<n&&choose+i<n){
                flag[(row+i)%n][(choose+i)%n]=true;//对角线
            }
            if(row+i<n&&choose-i>=0){
                flag[(row+i)%n][(choose-i)%n]=true;
            }
            if(row-i>=0&&choose+i<n){
                flag[(row-i)%n][(choose+i)%n]=true;
            }
            if(row-i>=0&&choose-i>=0){
                flag[(row-i)%n][(choose-i)%n]=true;
            }
        }
        int index=0;
        while(index<n){
            while(index<n&&flag[row+1][index]){
                index++;
            }
            if(index>=n){
                judge=true;
                return;
            }
            ans[row+1]=index;
            eightQueensPuzzle(row+1,flag,index);
            index++;
        }
    }
    public static void initFlagAndAns(boolean[][] flag){
        for(int i=0;i<flag.length;i++){
            for(int j=0;j< flag.length;j++){
                flag[i][j]=false;
            }
        }
        for(int i=0;i<n;i++){
            ans[i]=-1;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        ans=new int[n];
        int count=0;
        boolean[][] flag=new boolean[n][n];
        for(int i=0;i<n;i++){
            judge=false;
            initFlagAndAns(flag);
            ans[0]=i;
            eightQueensPuzzle(0,flag,i);
            if(!judge){
                count++;
                if(count<=3){
                    for(int j=0;j<n;j++){
                        System.out.print(ans[i]+' ');
                    }
                    System.out.println();
                }
            }
        }
        System.out.print(count);
    }
}

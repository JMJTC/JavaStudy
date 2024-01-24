package Algorithm.EveryWeekStudy.WinterContest1;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest08 {
    public static int powerMax(int [][]data){
        int[] record=new int[data.length];
        int left,right;
        for(int i=0;i< data.length;i++){
            left=i-1;right=i+1;
            while(left>=0&&data[left][0]<=data[i][0]){
                left--;
            }
            while(right< data.length&&data[right][0]<=data[i][0]){
                right++;
            }
            if(left>=0){
                record[left]+=data[i][1];
            }
            if(right< data.length){
                record[right]+=data[i][1];
            }
        }
        int max=record[0];
        for (int j : record) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n= sc.nextInt();
        int[][] data=new int[n][2];
        for(int i=0;i<n;i++){
            data[i][0]=sc.nextInt();
            data[i][1]=sc.nextInt();
        }

        System.out.println(powerMax(data));
    }
}

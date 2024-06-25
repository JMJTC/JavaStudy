package Algorithm.ruicom.test.province2023;

import java.util.Scanner;

public class Rc_u5 {
    /*
    1 0>1 1=0 0>0 1
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int length=sc.nextInt();
            int[][] arr=new int[length][2];
            int[] sortData=new int[length];
            for(int j=0;j<length;j++){
                arr[j][0]=sc.nextInt();
                arr[j][1]=sc.nextInt();
            }
            for(int j=0;j<length;j++){
                sortData[j]=sc.nextInt();
            }
            solution(arr,sortData);
        }
    }
    public static void solution(int[][] arr,int[] sortData){
        int[] sortThink=new int[sortData.length];

    }
}

package Algorithm.ContestLan.guo13;

import java.util.Scanner;
import java.util.SortedSet;

public class G {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();

        int[] weight=new int[n];
        int[] value=new int[n];
        int[][][] dp=new int[n][m+1][2];
        for(int i=0;i<n;i++){
            weight[i]=sc.nextInt();
            value[i]=sc.nextInt();
        }

    }
}



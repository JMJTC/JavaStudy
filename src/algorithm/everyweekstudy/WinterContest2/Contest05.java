package algorithm.everyweekstudy.WinterContest2;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest05 {
    public static int numberOfSeries(int n){
        int[] record=new int[n+1];
        record[0]=1;
        for(int i=1;i<=n;i++){
            int temp=i/2;
            while(temp>=0){
                record[i]+=record[temp];
                temp--;
            }
        }
        return record[n];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(numberOfSeries(n));
    }
}

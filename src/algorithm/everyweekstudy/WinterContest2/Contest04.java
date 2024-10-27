package algorithm.everyweekstudy.WinterContest2;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest04 {
    public static int sumOfLighting(int n){
        if(n%3==0){
            return n/3;
        }else{
            return n/3+1;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int lighters=sc.nextInt();
            System.out.println(sumOfLighting(lighters));
        }
    }
}

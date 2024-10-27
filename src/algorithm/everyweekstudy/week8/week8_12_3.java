package algorithm.everyweekstudy.week8;

import java.util.Scanner;

public class week8_12_3 {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {

        int[] a=new int[2];
        int[] b=new int[2];
        getState(a);
        getState(b);
        System.out.println(a[0]+a[1]);
        System.out.println(b[0]+b[1]);
    }
    public static void getState(int []a){
        for(int i=0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
    }
}

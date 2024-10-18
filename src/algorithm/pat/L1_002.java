package algorithm.pat;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class L1_002 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char c=sc.next().charAt(0);
        print(n,c);
    }

    public static void print(int n,char c){
        int count=0;
        int sum=3;
        n--;
        while (n>0){
            if(sum*2<n){
                n-=(sum*2);
                sum+=2;
                count++;
            }else{
                break;
            }
        }
        int temp=count;
        for(int i=count;i>=0;i--){
            //打印空格
            for(int j=0;j<temp-i;j++){
                System.out.print(' ');
            }
            //打印字母
            for(int j=0;j<2*i+1;j++){
                System.out.print(c);
            }
            System.out.println();
        }
        for(int i=1;i<=count;i++){
            //打印空格
            for(int j=0;j<temp-i;j++){
                System.out.print(' ');
            }
            //打印字母
            for(int j=0;j<2*i+1;j++){
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.print(n);
    }
}

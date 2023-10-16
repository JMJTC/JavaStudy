package week1;

import java.util.Scanner;

public class _1 {
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        n--;
        long a=n/3,b=n/5,c=n/15;
        long sum=a*(a+1)/2*3+b*(b+1)/2*5-c*(c+1)/2*15;
        System.out.println(sum);
    }
}

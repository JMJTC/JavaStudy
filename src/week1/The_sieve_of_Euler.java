package week1;

import java.util.Scanner;

public class The_sieve_of_Euler {
    public static void main(String[] args){
        int n;
        Scanner in=new Scanner(System.in);
        n= in.nextInt();
        boolean[] p=new boolean[n+1];//记录是否被筛掉
        int[] primes=new int[n];
        int count=0;
        for(int i=2;i<=n;i++){
            if(!p[i])
                primes[count++]=i;
            for(int j=0;j<=count&&i*primes[j]<=n;j++){
                p[i*primes[j]]=true;
                if(i%primes[j]==0)
                    break;
            }
        }
        for(int i=0;i<count;i++){
            System.out.printf("%d ",primes[i]);
        }
    }
}

package EveryWeekStudy.week1;

import java.math.BigInteger;
import java.util.Scanner;

public class _10_22_2 {
    public static void main(String[] args){
        int n;
        Scanner in=new Scanner(System.in);
        n= in.nextInt();
        int sum=0;
        String num= BigInteger.ONE.shiftLeft(n).toString();
        for(int i=0;i<num.length();i++){
            sum+=num.charAt(i)-'0';
        }
        System.out.println(sum);
    }
}

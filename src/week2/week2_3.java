package week2;

import java.math.BigInteger;
import java.util.Scanner;

public class week2_3 {
    public static BigInteger fact(int n){
        BigInteger sum=new BigInteger("1");
        for(int i=1;i<=n;i++){
            BigInteger temp=new BigInteger(String.valueOf(i));
            //System.out.println(temp);
            sum=sum.multiply(temp);
        }
        return sum;
    }
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args){
        int n,m;//n行m列
        n=in.nextInt();
        m=in.nextInt();

        //相当于在n+m个里面选n个,
        String answer=fact(n+m).divide(fact(n).multiply(fact(m))).toString() ;//阶乘导致数太大
        //排列组合还有更优的算法，过后再实现
        System.out.println(answer);

    }
}

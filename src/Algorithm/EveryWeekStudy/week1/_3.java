package Algorithm.EveryWeekStudy.week1;

import java.util.Scanner;
public class _3 {
    public static boolean IsPrime(long t){
        boolean re=true;
        for(long i=2;i<=t/i;i++){
            if(t%i==0){
                re=false;
                break;
            }
        }
        return re;
    }
    public static void main(String[] args){
        long n;
        Scanner in=new Scanner(System.in);
        n=in.nextLong();
        long MAX=2;
        long i=1;
        for(;i<=n;i++){
            if(n%i==0){//判断是否是该数的因数，从小到大，
                if(IsPrime(n/i)){//n/i即为当前的最大因数，判断其是否为素数
                    MAX=n/i;
                    break;
                }
                else{
                    n=n/i;//n变为其最大的因数，该因数为一个合数
                    i=1;
                }
            }
        }
        System.out.println(MAX);
    }
}

package week3;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week3_1 {
    static final int MAX =998244353;

    public static int pow2(long b){
        //long base=2;
        BigInteger base=new BigInteger("2");
        BigInteger ans=new BigInteger("1");
        while(b!=0){
            if(b%2!=0){
                BigInteger[] temp=ans.multiply(base).divideAndRemainder(new BigInteger("998244353"));
                ans=temp[1];
            }
            BigInteger[] temp1=(base.multiply(base)).divideAndRemainder(new BigInteger("998244353"));
            base=temp1[1];
            b/=2;
        }
//        for(long i=0;i<count;i++){
//            ans=(ans*base)%MAX;
//        }
        ans=ans.subtract(new BigInteger("1"));
        return ans.intValue();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        //int answer=pow2(2,n);
        //T(n)=2T(n-1)+1
        //T(n)=2^n-1
        System.out.println(pow2(n));
    }
}

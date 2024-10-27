package algorithm.everyweekstudy.week2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week2_4 {
    public static BigInteger fact(int n){
        BigInteger sum=new BigInteger("1");
        for(int i=1;i<=n;i++){
            BigInteger temp=new BigInteger(String.valueOf(i));
            //System.out.println(temp);
            sum=sum.multiply(temp);
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        BigInteger factN =fact(n);
        String strFacN=factN.toString();
        int length=strFacN.length();
        int sum=0;
        for(int i=0;i<length;i++){
            sum+=strFacN.charAt(i)-'0';
        }
        System.out.println(sum);
    }
}

package algorithm.everyweekstudy.WinterContest2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest02 {
    public static BigInteger minCountOfMouse(BigInteger n){
        BigInteger num=new BigInteger("1");
        BigInteger ans=new BigInteger("0");
        while(num.compareTo(n)<0){
            num=num.multiply(new BigInteger("2"));
            ans=ans.add(new BigInteger("1"));
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BigInteger n=sc.nextBigInteger();
        System.out.println(minCountOfMouse(n));
    }
}

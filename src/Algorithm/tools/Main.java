package Algorithm.tools;

import java.math.BigInteger;

/**
 * @author jmjtc
 */
public class Main {
    public static void main(String[] args) {
        BigInteger ans=new BigInteger("1");
        for(int i=1;i<=50;i++){
            ans=ans.multiply(BigInteger.valueOf(i+1));
            System.out.println(ans);
        }
    }
}

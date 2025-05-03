package algorithm.contestlan.province12th;

import java.math.BigInteger;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-02
 * @Description: 货物摆放
 * @Version: 1.0
 */
public class Problem4 {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("2002745558");
        BigInteger ans = new BigInteger("0");
        for (BigInteger i = BigInteger.valueOf(1); i.compareTo(bi) <= 0; i = i.add(BigInteger.valueOf(1))) {
            if (bi.mod(i).equals(BigInteger.ZERO)) {
                for (BigInteger j = BigInteger.valueOf(1); j.compareTo(bi.divide(i)) <= 0; j = j.add(BigInteger.valueOf(1))) {
                    if (bi.divide(i).mod(j).equals(BigInteger.ZERO)) {
                        ans = ans.add(new BigInteger("1"));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

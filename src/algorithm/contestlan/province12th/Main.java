package algorithm.contestlan.province12th;

import java.math.BigInteger;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-02
 * @Description: main
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("2021041820210418");
        BigInteger ans = BigInteger.ZERO;

        // 找出 bi 的所有因数
        java.util.ArrayList<BigInteger> factors = new java.util.ArrayList<>();
        for (BigInteger i = BigInteger.ONE; i.multiply(i).compareTo(bi) <= 0; i = i.add(BigInteger.ONE)) {
            if (bi.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
                if (!i.equals(bi.divide(i))) {
                    factors.add(bi.divide(i));
                }
            }
        }

        // 对于每个因数 i，找出 bi / i 的所有因数
        for (BigInteger i : factors) {
            BigInteger num = bi.divide(i);
            for (BigInteger j = BigInteger.ONE; j.multiply(j).compareTo(num) <= 0; j = j.add(BigInteger.ONE)) {
                if (num.mod(j).equals(BigInteger.ZERO)) {
                    ans = ans.add(BigInteger.ONE);
                    if (!j.equals(num.divide(j))) {
                        ans = ans.add(BigInteger.ONE);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}

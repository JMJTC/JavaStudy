package algorithm.contestlan.province14th;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-22
 * @Description: 互质
 * @Version: 1.0
 */
public class Problem1 {
    static final long MOD = 1000000007L;

    //φ(n)=n(1-1/p1)(1-1/p2)... 欧拉公式
    public static void main(String[] args) {
        long result = 6 * 16 % MOD;
        result = result * fastPower(7, 2022) % MOD;
        result = result * fastPower(17, 2 * 2023 - 1) % MOD;
        System.out.println(result);
    }

    //快速幂
    // 定义一个私有静态方法fastPower，用于计算base的exponent次幂，并对结果取模MOD
    private static long fastPower(long base, long exponent) {
        // 初始化结果为1
        long result = 1;

        // 当指数大于0时，继续循环
        while (exponent > 0) {
            // 检查当前指数的最低位是否为1
            if ((exponent & 1) == 1) {
                // 如果最低位为1，则将当前base乘到结果中，并对结果取模MOD
                result = result * base % MOD;
            }
            // 将base平方，并对结果取模MOD，用于下一次迭代
            base = base * base % MOD;

            // 将指数右移一位，相当于除以2，继续处理更高位的指数
            exponent >>= 1;
        }

        // 返回最终计算的结果
        return result;
    }
}

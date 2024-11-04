package algorithm.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-04
 * @Description: 平方数之和
 * @Version: 1.0
 */
public class Problem633 {
    public static void main(String[] args) {
        System.out.println(new Problem633().judgeSquareSum(3));
    }

    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new HashSet<>();
        int m=(int)Math.sqrt(c);
        for (int i = 0; i <=m; i++) {
            set.add(i * i);
        }
        for (Integer i : set) {
            if (set.contains(c - i)) {
                return true;
            }
        }
        return false;
    }

    //枚举
    public boolean judgeSquareSum1(int c) {
        for (int a = 0; a * a <= c / 2; a++) {
            int b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b == c) {
                return true;
            }
        }
        return false;
    }

    //双指针
    public boolean judgeSquareSum2(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            if (a * a == c - b * b) { // 避免溢出
                return true;
            }
            if (a * a < c - b * b) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }
}

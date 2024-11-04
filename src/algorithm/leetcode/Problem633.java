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
        set.add(0);
        for (int i = 1; i < Math.sqrt(Integer.MAX_VALUE); i++) {
            set.add(i * i);
        }
        for (Integer i : set) {
            if (set.contains(c - i)) {
                return true;
            }
        }
        return false;
    }
}

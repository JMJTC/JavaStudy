package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-23
 * @Description: 1399. 统计最大组的数目
 * @Version: 1.0
 */
public class Problem1399 {

    public int countLargestGroup(int n) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = getNumMathSum(i);
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }
        Map<Integer, Integer> hash2 = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            hash2.put(entry.getValue(), hash2.getOrDefault(entry.getValue(), 0) + 1);
        }
        return hash2.getOrDefault(hash2.keySet().stream().max(Integer::compareTo).get(), 0);
    }

    public int getNumMathSum(int i){
        int res = 0;
        while (i > 0){
            res += i % 10;
            i /= 10;
        }
        return res;
    }
}

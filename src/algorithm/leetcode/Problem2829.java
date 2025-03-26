package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-26
 * @Description: 2829. k-avoiding 数组的最小总和
 * @Version: 1.0
 */
public class Problem2829 {
    public static void main(String[] args) {

    }

    public int minimumSum(int n, int k) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        int index = 1;
        for (int i = 0; i < n; i++) {
            if(!set.contains(index)){
                ans += index;
                set.add(k - index);
            }else{
                i--;
            }
            index++;
        }
        return ans;
    }
}

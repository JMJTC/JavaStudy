package algorithm.offer150.ch03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-07-30
 * @Description: 209. 长度最小的子数组
 * @Version: 1.0
 */
public class Problem01 {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            deque.offer(nums[i]);
            sum += nums[i];
            if (sum >= target) {
                while (sum >= target) {
                    ans = Math.min(deque.size(), ans);
                    int temp = deque.getFirst();
                    if (sum - temp >= target) {
                        sum -= temp;
                        deque.poll();
                    } else {
                        break;
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

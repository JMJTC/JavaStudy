package algorithm.offer150.ch03;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-07-30
 * @Description: 3. 无重复字符的最长子串
 * @Version: 1.0
 */
public class Problem02 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        char[] str = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            if (!set.contains(str[i])) {
                set.add(str[i]);
                deque.offer(str[i]);
                ans = Math.max(deque.size(), ans);
            } else {
                while (set.contains(str[i])) {
                    set.remove(deque.poll());
                }
                set.add(str[i]);
                deque.offer(str[i]);
            }
        }
        return ans;
    }
}

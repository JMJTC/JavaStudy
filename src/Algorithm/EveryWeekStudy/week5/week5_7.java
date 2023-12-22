package Algorithm.EveryWeekStudy.week5;

import java.util.*;

/**
 * @author jmjtc
 */
public class week5_7 {
}

class week5_7_Solution1{
    public int lengthOfLongestSubstring(String s) {
        char[] str=s.toCharArray();
        //队列记录连续不重复序列
        Queue<Character> queue=new LinkedList<>();
        //ans记录每个连续序列的长度
        List<Integer> ans=new ArrayList<>();
        for (char c : str) {
            if (!queue.contains(c)) {
                //不重复则入队
                queue.offer(c);
                ans.add(queue.size());
            } else {
                //重复则：该字符上一次出现的位置及之前元素出队
                while (queue.peek() != c) {
                    queue.poll();
                }
                queue.poll();
                queue.offer(c);
            }
        }
        return ans.isEmpty()?0:Collections.max(ans);
    }
}

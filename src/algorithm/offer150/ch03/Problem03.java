package algorithm.offer150.ch03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-07-30
 * @Description: 30. 串联所有单词的子串
 * @Version: 1.0
 */
public class Problem03 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int length = words[0].length() * words.length;
        int size = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        for (int i = 0; i < words[0].length(); i++) {
            int l = i;
            int r = i + size;
            Map<String, Integer> tempMap = new HashMap<>(map);
            while (l < s.length() && r <= s.length()) {
                String temp = null;
                temp = s.substring(r - size, r);
                if (tempMap.containsKey(temp) && tempMap.get(temp) != 0) {
                    tempMap.put(temp, tempMap.get(temp) - 1);
                    if (r - l == length) {
                        ans.add(l);
                    }
                    r += size;
                } else {
                    if (tempMap.containsKey(temp)) {
                        // 滑动
                        while (tempMap.get(temp) == 0) {
                            String str = s.substring(l, l + size);
                            tempMap.put(str, tempMap.get(str) + 1);
                            l += size;
                        }
                    } else {
                        tempMap = new HashMap<>(map);
                        l = r;
                        r += size;
                    }
                }

            }

        }
        return ans;
    }
}

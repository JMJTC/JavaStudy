package algorithm.offer150.ch01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-07
 * @Description: 13. 罗马数字转整数 <a href="https://leetcode.cn/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @Version: 1.0
 */
public class Problem17 {
    public static void main(String[] args) {
        Problem17 p = new Problem17();
        System.out.println(p.romanToInt("LVIII"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        initMap(map);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }

    private void initMap(Map<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}

package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-24
 * @Description: 2255. 统计是给定字符串前缀的字符串数目
 * @Version: 1.0
 */
public class Problem2255 {
    public static void main(String[] args) {

    }

    //String 判断前缀 startWith
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                ans++;
            }
        }
        return ans;
    }


    public int countPrefixes1(String[] words, String s) {
        int length = words.length;
        int maxLength = s.length();
        int ans = 0;
        for (String word : words) {
            if (word.length() <= maxLength) {
                int index = 0;
                boolean flag = true;
                while (index < word.length()) {
                    if (word.charAt(index) == s.charAt(index)) {
                        index++;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

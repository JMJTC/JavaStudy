package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-05-25
 * @Description:2131. 连接两字母单词得到的最长回文串
 * @Version: 1.0
 */
public class Problem2131 {
    public static void main(String[] args) {

    }

    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];
        for (String w : words) {
            count[w.charAt(0) - 'a'][w.charAt(1) - 'a']++;
        }

        int ans = 0;
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            int c = count[i][i];
            ans += c - c % 2;
            odd |= c % 2;
            for (int j = i + 1; j < 26; j++) {
                ans += Math.min(count[i][j], count[j][i]) * 2;
            }
        }
        return (ans + odd) * 2;
    }
}

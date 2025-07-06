package algorithm.offer150.ch02;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-07-06
 * @Description: 125. 验证回文串 <a href="https://leetcode.cn/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @Version: 1.0
 */
public class Problem01 {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        Problem01 test = new Problem01();
        test.isPalindrome(str);
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !isLetterOrNum(s.charAt(l))) {
                l++;
            }
            while (l < r && !isLetterOrNum(s.charAt(r))) {
                r--;
            }
            if (toLowLetter(s.charAt(l)) != toLowLetter(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isLetterOrNum(char ch) {
        return (ch <= 'z' && ch >= 'a') || (ch <= 'Z' && ch >= 'A') || (ch >= '0' && ch <= '9');
    }

    public boolean isLetter(char ch) {
        return (ch <= 'z' && ch >= 'a') || (ch <= 'Z' && ch >= 'A');
    }

    public char toLowLetter(char ch) {
        if (!isLetter(ch)) {
            return ch;
        }
        if (ch <= 'z' && ch >= 'a') {
            return ch;
        }

        return (char)(ch - 'A' + 'a');
    }
}

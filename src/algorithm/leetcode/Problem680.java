package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-03
 * @Description: 680. 验证回文串 II
 * @Version: 1.0
 */
public class Problem680 {
    public static void main(String[] args) {

    }

    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                break;
            }
            l++;
            r--;
        }
        if(l>=r){
            return true;
        }
        //先删左边
        int copyL=l;
        int copyR=r;
        l++;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                break;
            }
            l++;
            r--;
        }
        if(l>=r){
            return true;
        }
        //删右边
        l=copyL;
        r=copyR-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                break;
            }
            l++;
            r--;
        }
        if(l>=r){
            return true;
        }
        return false;
    }

    public boolean validPalindrome1(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            l++;
            r--;
        }
        if (l >= r) {
            return true;
        }

        // 封装成函数来检查从当前 l 和 r 开始是否是回文
        return isPalindromeRange(s, l + 1, r) || isPalindromeRange(s, l, r - 1);
    }

    private boolean isPalindromeRange(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

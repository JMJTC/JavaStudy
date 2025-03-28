package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-28
 * @Description: 2716. 最小化字符串长度
 * @Version: 1.0
 */
public class Problem2716 {
    public static void main(String[] args) {

    }
    public int minimizedStringLength(String s) {
        int ans = 0;
        int length = s.length();
        int[] count = new int[26];
        for(int i = 0; i < length; i++){
            count[s.charAt(i)-'a']++;
        };
        for(int i : count){
            if(i > 0){
                ans++;
            }
        }
        return ans;
    }
}

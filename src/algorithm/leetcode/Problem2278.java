package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-31
 * @Description: 2278. 字母在字符串中的百分比
 * @Version: 1.0
 */
public class Problem2278 {
    public static void main(String[] args) {

    }

    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (char c : s.toCharArray()){
            if(c == letter){
                count++;
            }
        }
        return count * 100 / s.length();
    }
}

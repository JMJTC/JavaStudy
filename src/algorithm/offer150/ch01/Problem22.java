package algorithm.offer150.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-08
 * @Description: 6. Z 字形变换 <a href="https://leetcode.cn/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @Version: 1.0
 */
public class Problem22 {
    public static void main(String[] args) {

    }
    public String convert(String s, int numRows) {
        int mod = numRows * 2 - 2;
        if (mod == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += mod) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && j + mod - 2 * i < s.length()) {
                    sb.append(s.charAt(j + mod - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}

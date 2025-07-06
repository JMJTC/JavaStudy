package algorithm.offer150.ch02;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-07-06
 * @Description: 392. 判断子序列
 * @Version: 1.0
 */
public class Problem02 {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if (length1 > length2) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < length1 && index2 < length2) {
            if (s.charAt(index1) == t.charAt(index2)) {
                index1++;
                index2++;
            }
            index2++;
        }
        return index1 >= length1;
    }
}

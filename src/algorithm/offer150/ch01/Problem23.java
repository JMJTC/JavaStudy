package algorithm.offer150.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-09
 * @Description: 28. 找出字符串中第一个匹配项的下标 <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @Version: 1.0
 */
public class Problem23 {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        // 初始化返回值为-1，表示未找到匹配的子字符串
        int ans = -1;

        // 获取haystack字符串的长度
        int length1 = haystack.length();

        // 获取needle字符串的长度
        int length2 = needle.length();

        // 遍历haystack字符串的每一个字符
        for (int i = 0; i < length1; i++) {
            // 如果当前字符与needle的第一个字符相同，则进行进一步匹配
            if (haystack.charAt(i) == needle.charAt(0)) {
                // 初始化标志位为true，表示当前匹配成功
                boolean flag = true;

                // 遍历needle字符串的每一个字符
                for (int j = 0; j < length2; j++) {
                    // 如果当前匹配位置超出haystack的长度，或者字符不匹配，则标志位设为false并退出循环
                    if (i + j >= length1 || needle.charAt(j) != haystack.charAt(i + j)) {
                        flag = false;
                        break;
                    }
                }

                // 如果标志位仍为true，表示needle字符串完全匹配haystack的子字符串，返回匹配的起始位置
                if (flag) {
                    return i;
                }
            }
        }

        // 如果遍历完haystack仍未找到匹配的子字符串，返回-1
        return ans;
    }
}

package algorithm.offer150.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-07
 * @Description: 58. 最后一个单词的长度 <a href="https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @Version: 1.0
 */
public class Problem19 {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if (words.length == 0) {
            return 0;
        }
        return words[words.length - 1].length();
    }
}

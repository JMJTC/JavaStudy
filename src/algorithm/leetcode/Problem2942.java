package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-05-24
 * @Description:2942. 查找包含给定字符的单词
 * @Version: 1.0
 */
public class Problem2942 {
    public static void main(String[] args) {

    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) {
                ans.add(i);
            }
        }
        return ans;
    }


    public List<Integer> findWordsContaining2(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}

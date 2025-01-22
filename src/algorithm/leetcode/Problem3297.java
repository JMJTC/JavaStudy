package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-01-09
 * @Description: 3297. 统计重新排列后包含另一个字符串的子字符串数目 I
 * @Version: 1.0
 */
public class Problem3297 {
    public static void main(String[] args) {

    }


    

    public long validSubstringCount(String word1, String word2) {
        // 初始化一个长度为26的数组，用于记录word2中每个字母出现的次数
        int[] count = new int[26];
        // 遍历word2，统计每个字母的出现次数
        for (char c : word2.toCharArray()) {
            count[c - 'a']++;
        }

        // 获取word1的长度
        int n = word1.length();
        // 初始化一个二维数组，用于记录word1中前缀字符出现的次数
        int[][] preCount = new int[n + 1][26];
        // 遍历word1，填充preCount数组
        for (int i = 1; i <= n; i++) {
            // 复制前一个前缀的字符出现次数
            for (int j = 0; j < 26; j++) {
                preCount[i][j] = preCount[i - 1][j];
            }
            // 针对当前遍历到的字符自增
            preCount[i][word1.charAt(i - 1) - 'a']++;
        }

        // 初始化结果变量
        long res = 0;
        // 遍历word1的每个前缀
        for (int l = 1; l <= n; l++) {
            // 获取当前前缀的最长有效后缀索引
            int r = get(l, n + 1, preCount, count);
            // 计算当前前缀的有效子字符串数量
            res += n - r + 1;
        }
        return res;
    }

    // 二分查找获取当前前缀的最长有效后缀索引
    private int get(int l, int r, int[][] preCount, int[] count) {
        // 初始化边界
        int border = l;
        // 二分查找
        while (l < r) {
            // 计算中间索引
            int m = (l + r) >> 1;
            // 标志位，用于判断当前前缀是否有效
            boolean f = true;
            // 遍历所有字母
            for (int i = 0; i < 26; i++) {
                // 如果当前前缀中字母i的出现次数小于word2中字母i的出现次数，则当前前缀无效
                if (preCount[m][i] - preCount[border - 1][i] < count[i]) {
                    f = false;
                    break;
                }
            }
            // 如果当前前缀有效，则缩小右边界
            if (f) {
                r = m;
            } else {
                // 否则，缩小左边界
                l = m + 1;
            }
        }
        return l;
    }
}

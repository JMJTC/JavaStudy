package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-05-04
 * @Description: 1128. 等价多米诺骨牌对的数量
 * @Version: 1.0
 */
public class Problem1128 {
    public static void main(String[] args) {

    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int length = dominoes.length;
        boolean[] flag = new boolean[length];
        int[] count = new int[length];
        for (int i = 0; i < length; i++) {
            flag[i] = true;
            count[i] = 0;
        }
        for (int i = 0; i < length; i++) {
            if (flag[i]) {
                flag[i] = false;
                for (int j = i + 1; j < length; j++) {
                    if (flag[j]) {
                        if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
                                || (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])) {
                            count[i]++;
                            flag[j] = false;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            ans += count[i] * (count[i] + 1) / 2;
        }
        return ans;
    }
}

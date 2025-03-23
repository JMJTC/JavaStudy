package algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-22
 * @Description: 2643. 一最多的行
 * @Version: 1.0
 */
public class Problem2643 {
    public static void main(String[] args) {

    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        // 初始化一个长度为2的数组，用于存储结果，ans[0]存储行索引，ans[1]存储最大1的个数
        int[] ans = new int[2];
        // 遍历矩阵的每一行
        for (int i = 0; i < mat.length; i++) {
            // 初始化当前行的1的个数为0
            int sum = 0;
            // 遍历当前行的每一列
            for (int j = 0; j < mat[0].length; j++) {
                // 如果当前元素为1，则将sum加1
                sum += mat[i][j];
            }
            //可用库函数优化
            //int sum = Arrays.stream(mat[i]).sum();
            // 如果当前行的1的个数大于ans[1]，则更新ans[0]和ans[1]
            if (sum > ans[1]) {
                ans[0] = i;
                ans[1] = sum;
            }
        }
        // 返回结果数组
        return ans;
    }
}

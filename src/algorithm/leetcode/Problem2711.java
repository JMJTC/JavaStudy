package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-25
 * @Description: 2711. 对角线上不同值的数量差
 * @Version: 1.0
 */
public class Problem2711 {
    public static void main(String[] args) {

    }

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //计算 topLeft[i][j]
                st.clear();
                for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
                    st.add(grid[x][y]);
                }
                int topLeft = st.size();

                //计算 buttomRight[i][j]
                st.clear();
                for (int x = i + 1, y = j + 1; x < m && y < n; x++, y++) {
                    st.add(grid[x][y]);
                }
                int buttomRight = st.size();

                ans[i][j] = Math.abs(topLeft - buttomRight);
            }
        }
        return ans;
    }
}

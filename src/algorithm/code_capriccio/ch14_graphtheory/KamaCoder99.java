package algorithm.code_capriccio.ch14_graphtheory;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-14
 * @Description:
 * @Version: 1.0
 */
public class KamaCoder99 {
    private static final int[][] DIRECTION = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            String[] str = s.split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }

        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    ans++;
                    //dfs(matrix, visited, i, j);
                    bfs(matrix, visited, i, j);
                }
            }
        }
        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int[][] matrix, boolean[][] visited, int x, int y) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int xx = point[0];
            int yy = point[1];
            for (int i = 0; i < 4; i++) {
                int curX = xx + DIRECTION[i][0];
                int curY = yy + DIRECTION[i][1];
                if (curY < 0 || curY >= matrix[0].length || curX < 0 || curX >= matrix.length) {
                    continue;
                }
                if (!visited[curX][curY] && matrix[curX][curY] == 1) {
                    queue.offer(new int[]{curX, curY});
                    visited[curX][curY] = true;
                }
            }
        }
    }

    private static void dfs(int[][] matrix, boolean[][] visited, int x, int y) {
        if (visited[x][y] || matrix[x][y] == 0) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xx = x + DIRECTION[i][0];
            int yy = y + DIRECTION[i][1];
            if (xx < 0 || xx >= matrix.length || yy < 0 || yy >= matrix[0].length) {
                continue;
            }
            visited[x][y] = true;
            dfs(matrix, visited, xx, yy);
        }
    }
}

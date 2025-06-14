package algorithm.code_capriccio.ch14_graphtheory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-13
 * @Description:
 * @Version: 1.0
 */
public class KamaCoder98 {
    private static List<Integer> path = new ArrayList<>();
    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);

        // 邻接矩阵 || 领接表
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            s = br.readLine();
            int x = Integer.parseInt(s.split(" ")[0]);
            int y = Integer.parseInt(s.split(" ")[1]);
            graph[x][y] = 1;
        }
        path.add(1);
        backTracking(graph, 1, n);

        if (ans.isEmpty()) {
            System.out.println(-1);
            return;
        }
        for (List<Integer> list : ans) {
            for (int i = 0; i < list.size() - 1; i++) {
                bw.write(list.get(i) + " ");
            }
            bw.write(list.get(list.size() - 1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backTracking(int[][] graph, int index, int target) {
        if (index == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= target; i++) {
            if (graph[index][i] == 1) {
                path.add(i);
                backTracking(graph, i, target);
                path.remove(path.size() - 1);
            }
        }
    }
}

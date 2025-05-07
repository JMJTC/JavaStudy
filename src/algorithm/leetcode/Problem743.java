package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-05-07
 * @Description: 743. 网络延迟时间
 * @Version: 1.0
 */
public class Problem743 {
    public static void main(String[] args) {

    }

    //朴素 Dijkstra
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int[] row : g) {
            Arrays.fill(row, INF);
        }
        for (int[] t : times) {
            g[t[0] - 1][t[1] - 1] = t[2];
        }

        int maxDis = 0;
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[k - 1] = 0;
        boolean[] done = new boolean[n];
        while (true) {
            int x = -1;
            for (int i = 0; i < n; i++) {
                if (!done[i] && (x < 0 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            if (x < 0) {
                return maxDis;
            }
            if (dis[x] == INF) {
                return -1;
            }
            maxDis = dis[x];
            done[x] = true;
            for (int y = 0; y < n; y++) {
                // 更新 x 的邻居的最短路
                dis[y] = Math.min(dis[y], dis[x] + g[x][y]);
            }
        }
    }

    // 堆优化 Dijkstra
    public int networkDelayTime1(int[][] times, int n, int k) {
        List<int[]>[] list = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            list[i] = new ArrayList<>();
//        }
        Arrays.setAll(list, i -> new ArrayList<>());
        for (int[] t : times) {
            list[t[0] - 1].add(new int[]{t[1] - 1, t[2]}); // 建图
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;
        int count = n;
        int maxDis = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k - 1, 0});
        while (!pq.isEmpty() && count > 0) {
            int[] pair = pq.poll();
            int u = pair[0], d = pair[1];
            if (d > dist[u]) {
                continue;
            }
            count--;
            maxDis = Math.max(maxDis, d); // 记录最大距离,其实也不用比较，最短路会越来越大，直接 maxDis = d 即可
            for (int[] next : list[u]) { // 遍历所有相邻节点
                int v = next[0], w = next[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return count == 0 ? maxDis : -1;
    }
}

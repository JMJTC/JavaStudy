package algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-29
 * @Description: 2360. 图中的最长环
 * @Version: 1.0
 */
public class Problem2360 {
    public static void main(String[] args) {

    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        int ans = -1;
        int curTime = 1;
        int[] visTime = new int[n];
        for (int i = 0; i < n; i++) {
            int x = i;
            int startTime = curTime;
            while (x != -1 && visTime[x] == 0) {
                visTime[x] = curTime++;
                x = edges[x];
            }
            if (x != -1 && visTime[x] >= startTime) {// x在本轮循环中访问了两次，说明x 在环上
                ans = Math.max(ans, curTime - visTime[x]);
            }
        }
        return ans;
    }

    public int longestCycle1(int[] edges) {
        int length = edges.length;

        // 记录每个节点的入度
        int[] degreeIn = new int[length];
        for (int i : edges) {
            if (i != -1) {
                degreeIn[i]++;
            }
        }

        // 拓扑排序，移除所有入度为0的节点，得到有向环中的全部节点
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (degreeIn[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            int v = edges[u]; // u -> v
            if (v != -1) {
                degreeIn[v]--;
                if (degreeIn[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        int ans = -1;
        // 遍历所有节点，找到有向环中的最长环
        int[] visit = new int[length];
        for (int i = 0; i < length; i++) {
            if (visit[i] == 0 && degreeIn[i] != 0) {
                int temp = bfs(i, visit, edges);
                ans = Math.max(temp, ans);
            }
        }
        return ans;
    }

    // 使用广度优先搜索（BFS）找到从节点u开始的最长环
    private int bfs(int u, int[] visit, int[] edges) {
        int ans = 0;
        while (visit[u] == 0) {
            visit[u] = 1;
            ans++;
            u = edges[u];
        }
        return ans;
    }
}

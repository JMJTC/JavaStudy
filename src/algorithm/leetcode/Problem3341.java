package algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-05-07
 * @Description: 3341. 到达最后一个房间的最少时间 I
 * @Version: 1.0
 */
public class Problem3341 {
    public static void main(String[] args) {

    }

    // 回溯不一定能找到最优解
    private final int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int minTime = Integer.MAX_VALUE;

    public int minTimeToReach(int[][] moveTime) {
        backTracking(moveTime, 0, 0, 0, moveTime.length - 1, moveTime[0].length - 1);
        return minTime;
    }

    private void backTracking(int[][] moveTime, int nowTime, int x, int y, int targetX, int targetY) {
        if (x == targetX && y == targetY) {
            //到达终点
            if (nowTime < minTime) {
                minTime = nowTime;
            }
            return;
        }

        //两个方向走
        for (int i = 0; i < 4; i++) {
            x += direction[i][0];
            y += direction[i][1];
            if (x < 0 || x > targetX || y > targetY || y < 0) {
                x -= direction[i][0];
                y -= direction[i][1];
                continue;
            }
            int tempTime = nowTime;
            if (moveTime[x][y] > tempTime) {
                tempTime = moveTime[x][y];
            }
            tempTime += 1;
            backTracking(moveTime, tempTime, x, y, targetX, targetY);
            // 回溯
            x -= direction[i][0];
            y -= direction[i][1];
        }
    }

    // dijkstra 堆优化版
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 定义一个方法，用于计算从起点到终点的最短时间
    public int minTimeToReach2(int[][] moveTime) {
        // 获取矩阵的行数和列数
        int n = moveTime.length;
        int m = moveTime[0].length;

        // 初始化距离矩阵，所有元素初始值为最大整数
        int[][] dis = new int[n][m];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // 起点的距离为0
        dis[0][0] = 0;

        // 使用优先队列来存储待处理的节点，按照距离从小到大排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0 ,0});

        // 无限循环，直到找到终点
        while (true) {
            // 从优先队列中取出距离最小的节点
            int[] p = pq.poll();
            int d = p[0], i = p[1], j = p[2];
            // 如果当前节点是终点，返回距离
            if (i == n -1 && j == m -1) {
                return d;
            }
            // 如果当前节点的距离大于记录的最短距离，跳过
            if (d > dis[i][j]) {
                continue;
            }
            // 初始化时间增量
            int time = 1;
            // 遍历四个方向
            for (int[] q : DIRS) {
                int x = i + q[0], y = j + q[1];
                // 检查新坐标是否在矩阵范围内
                if (x >= 0 && x < n && y >= 0 && y < m){
                    // 计算新的距离
                    int newDis = Math.max(d, moveTime[x][y]) + time;
                    // 如果新的距离小于记录的最短距离，更新距离并加入优先队列
                    if (newDis < dis[x][y]) {
                        dis[x][y] = newDis;
                        pq.add(new int[]{newDis, x, y});
                    }
                }
            }
        }
    }

    // dijkstra 朴素版
    public int minTimeToReach3(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dis = new int[n][m];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        boolean[][] visited = new boolean[n][m];
        while (true) {
            for (int[] d : DIRS) {
                int i = d[0], j = d[1];
                
            }
        }
    }
}

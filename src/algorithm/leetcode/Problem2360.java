package algorithm.leetcode;

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
        for(int i = 0; i < n; i++){
            int x = i;
            int startTime = curTime;
            while(x != -1 && visTime[x] == 0){
                visTime[x] = curTime++;
                x = edges[x];
            }
            if(x != -1 && visTime[x] >= startTime){// x在本轮循环中访问了两次，说明x 在环上
                ans = Math.max(ans, curTime - visTime[x]);
            }
        }
        return ans;
    }
}

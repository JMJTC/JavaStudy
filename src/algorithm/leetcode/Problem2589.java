package algorithm.leetcode;

import java.util.Arrays;

public class Problem2589 {
    public static void main(String[] args) {

    }

    // 方法1：贪心
    public int findMinimumTime(int[][] tasks) {
        // 输入 tasks[i] = [start, end, duration]
        // 排序 tasks[i] = [start, end, duration] 根据结束时间 end 排序
        int n=tasks.length;
        Arrays.sort(tasks,(a,b)->a[1]-b[1]);
        // 记录每个时间点上是否在运行任务
        int[] run=new int[tasks[n-1][1]+1];
        int res=0;
        for(int i=0;i<n;i++){
            int start=tasks[i][0],end=tasks[i][1],duration=tasks[i][2];
            // 计算在 start 时刻运行任务的时间
            for(int j=start;j<=end;j++){
                duration-=run[j];
            }
            // 累加当前任务运行时间
            res+=Math.max(duration,0);
            // 在 end 时刻结束任务，任务运行时间为 duration
            for(int j=end;j>=0&&duration>0;j--){
                if(run[j]==0){
                    duration--;
                    run[j]=1;
                }
            }
        }
        return res;
    }
}

package algorithm.LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Problem2454 {
}

class Problem2454Solution {
    public int[] secondGreaterElement(int[] nums) {
        int length=nums.length;
        int[] ans=new int[length];
        Arrays.fill(ans,-1);
        Deque<Integer> stack=new ArrayDeque<Integer>();
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a, b)->a[0]-b[0]);
        for(int i=0;i<length;i++){
            while(!pq.isEmpty()&&pq.peek()[0]<nums[i]){
                ans[pq.poll()[1]]=nums[i];
            }
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                pq.offer(new int[]{nums[stack.peek()],stack.peek()});
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}

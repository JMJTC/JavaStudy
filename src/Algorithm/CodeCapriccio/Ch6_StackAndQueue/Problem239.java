package Algorithm.CodeCapriccio.Ch6_StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jmjtc
 */
public class Problem239 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,3,1,2,0,5};
        new Problem239().maxSlidingWindow(nums,3);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        int index=0;
        Deque<Integer> deque=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty()&&deque.getFirst()<i-k+1){
                deque.pollFirst();
            }
            while(!deque.isEmpty()&&nums[deque.getLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i>=k-1){
                ans[index++]=nums[deque.getFirst()];
            }
        }
        return ans;
    }
}

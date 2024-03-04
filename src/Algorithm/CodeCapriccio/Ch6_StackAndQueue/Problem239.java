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
        //定义一个长度为nums.length-k+1的int数组ans
        int[] ans=new int[nums.length-k+1];
//定义一个index变量，用于记录ans数组的下标
        int index=0;
//定义一个双端队列deque
        Deque<Integer> deque=new LinkedList<>();
//遍历nums数组
for(int i=0;i<nums.length;i++){
    //当队列不为空，且队列头部的元素小于i-k+1时，将队列头部的元素出队
    while(!deque.isEmpty()&&deque.getFirst()<i-k+1){
        deque.pollFirst();
    }
    //当队列不为空，且队列尾部的元素小于nums[i]时，将队列尾部的元素出队
    while(!deque.isEmpty()&&nums[deque.getLast()]<nums[i]){
        deque.pollLast();
    }
    //将当前元素i入队
    deque.offer(i);
    //当i大于等于k-1时，将队列头部的元素赋值给ans数组
    if(i>=k-1){
        ans[index++]=nums[deque.getFirst()];
    }
}
//返回ans数组
return ans;
    }
}

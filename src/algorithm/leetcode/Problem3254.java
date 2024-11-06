package algorithm.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-06
 * @Description: 3254. 长度为 K 的子数组的能量值 I
 * @Version: 1.0
 */
public class Problem3254 {
    public static void main(String[] args) {

    }

    public int[] resultsArray(int[] nums, int k) {
        // 创建一个长度为nums.length-k+1的数组ans，并将所有元素初始化为-1
        int[] ans=new int[nums.length-k+1];
        Arrays.fill(ans,-1);
        // 创建一个计数器count，用于记录连续递增的元素个数
        int count=0;
        // 遍历nums数组
        for(int i=0;i<nums.length;i++){
            // 如果当前元素是第一个元素或者当前元素等于前一个元素加1，则计数器加1
            if(i==0||nums[i]==nums[i-1]+1){
                count++;
            }else{
                // 否则，计数器重置为1
                count=1;
            }
            // 如果计数器大于等于k，则将当前元素赋值给ans数组中对应的位置
            if(count>=k){
                ans[i-k+1]=nums[i];
            }
        }
        // 返回ans数组
        return ans;
    }
}

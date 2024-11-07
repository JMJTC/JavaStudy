package algorithm.offer150.ch01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-07
 * @Description: <a href="https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150">多数元素</a>
 * @Version: 1.0
 */
public class Problem05 {
    public static void main(String[] args) {
        int[] nums=new int[]{3,2,3};
        System.out.println(new Problem05().majorityElement(nums));
    }


    /**
     * 时间复杂度：O(n) 空间复杂度：O(n)
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> hash=new HashMap<>();
        int target=(nums.length+1)/2;
        for(int i=0;i<nums.length;i++){
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
            if(hash.get(nums[i])>=target){
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 时间 O(n) 空间 O(1)
     * 投票算法： 可以看成水果消消乐，但玩法是不同的水果两两消失。最后剩余的一定是超过半数的水果
     */
    public int majorityElement2(int[] nums) {
        int count=0;
        int candidate=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidate=nums[i];
            }
            if(candidate!=nums[i]){
                count--;
            }else{
                count++;
            }
        }
        return candidate;
    }
}

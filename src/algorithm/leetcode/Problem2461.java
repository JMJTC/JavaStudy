package algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-06
 * @Description: 2461. 长度为 K 子数组中的最大和
 * @Version: 1.0
 */
public class Problem2461 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 7, 8, 9};
        System.out.print(new Problem2461().maximumSubarraySum(nums, 3));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        // 定义结果变量
        long ans = 0;
        // 定义临时变量
        long temp = 0;
        // 获取数组长度
        int n = nums.length;
        // 定义计数器
        int count=0;
        // 定义哈希表
        HashMap<Integer, Integer> hash = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < n; i++) {
            // 将数组元素放入哈希表，并计数
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
            // 将数组元素累加到临时变量
            temp+=nums[i];
            // 计数器加一
            count++;
            // 如果计数器等于k
            if(count==k){
                // 计数器减一
                count--;
                // 如果哈希表的大小等于k
                if(hash.size()==k){
                    // 如果结果变量小于临时变量
                    if(ans<temp){
                        // 将临时变量赋值给结果变量
                        ans=temp;
                    }
                }
                // 如果哈希表中当前元素的数量小于等于1
                if(hash.get(nums[i-k+1])<=1){
                    // 从哈希表中移除当前元素
                    hash.remove(nums[i-k+1]);
                }else{
                    // 将哈希表中当前元素的数量减一
                    hash.put(nums[i-k+1],hash.get(nums[i-k+1])-1);
                }
                // 将临时变量减去当前元素
                temp-=nums[i-k+1];
            }
        }
        // 返回结果变量
        return ans;
    }
}

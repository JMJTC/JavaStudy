package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-05
 * @Description: 子集2
 * @Version: 1.0
 */
public class Problem90 {
    public static void main(String[] args) {
        new Problem90().subsetsWithDup(new int[]{1,2,2});
    }

    private List<List<Integer>>  ans=new ArrayList<>(); // 存储所有子集的列表
private List<Integer> temp=new ArrayList<>(); // 存储当前子集的列表
public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // 对数组进行排序，方便去重
        for(int i=0;i<=nums.length;i++){ // 遍历所有可能的子集大小
            backtracking(0,i,nums); // 调用回溯函数
        }
        return ans; // 返回所有子集的列表
    }
    public void backtracking(int index,int count,int[] nums){
        if(temp.size()==count){ // 如果当前子集的大小等于目标大小
            ans.add(new ArrayList<>(temp)); // 将当前子集添加到结果列表中
            return;
        }
        for(int i=index;i<nums.length;i++){ // 遍历数组中的元素
            temp.add(nums[i]); // 将当前元素添加到子集中
            backtracking(i+1,count,nums); // 递归调用回溯函数，继续添加下一个元素
            while(i<nums.length-1&&nums[i+1]==temp.get(temp.size()-1)){ // 如果当前元素和下一个元素相同，则跳过
                i++;
            }
            temp.remove(temp.size()-1); // 移除当前子集中的最后一个元素，回溯
        }
    }
}

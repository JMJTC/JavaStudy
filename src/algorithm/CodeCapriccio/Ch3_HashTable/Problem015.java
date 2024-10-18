package algorithm.CodeCapriccio.Ch3_HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem015 {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            //如果排序后第一个元素大于0，则不可能组成三元组
            if(nums[i]>0){
                return ans;
            }
            if(i>0&&nums[i]==nums[i-1]){//去重a
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(right>left){
                int sum=nums[i]+nums[right]+nums[left];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    //找到了一个三元组
                    ans.add(Arrays.asList(nums[i],nums[right],nums[left]));
                    //去重
                    while(right>left&&nums[right]==nums[right-1]){
                        right--;
                    }
                    while(right>left&&nums[left]==nums[left+1]){
                        left++;
                    }

                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}

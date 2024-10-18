package algorithm.CodeCapriccio.Ch3_HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem018 {
    public static void main(String[] args) {
        int []nums=new int[]{1000000000,1000000000,1000000000,1000000000};
        new Problem018().fourSum(nums,-294967296);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int index=0;index<nums.length;index++){
            int newTarget=target-nums[index];
            //对第一个数去重
            if(index>0&&nums[index]==nums[index-1]){
                continue;
            }
            for(int i=index+1;i<nums.length;i++) {
                //对第二个数去重
                if(i>index+1&&nums[i]==nums[i-1]){
                    continue;
                }
                int left, right;
                left = i + 1;
                right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + (long)nums[left] + (long)nums[right];
                    if (sum > newTarget) {
                        right--;
                    } else if (sum < newTarget) {
                        left++;
                    } else {
                        ans.add(Arrays.asList(nums[index], nums[i], nums[left], nums[right]));
                        //去重操作
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}

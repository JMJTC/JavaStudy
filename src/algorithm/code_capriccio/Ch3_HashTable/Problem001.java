package algorithm.code_capriccio.Ch3_HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jmjtc
 */
public class Problem001 {
    public static void main(String[] args) {
        int[] test=new int []{0,1,2,4,5};
        new Problem001().twoSum1(test,2);
    }
    //双层for循环,暴力求解,时间复杂度O（n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }
    public int[] twoSum1(int[] nums, int target){
        int[] ans=new int[2];
        Map<Integer,Integer> record=new HashMap<>();
        if(nums.length == 0){
            return ans;
        }
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(record.containsKey(temp)){
                ans[0]=i;
                ans[1]=record.get(temp);
                break;
            }
            record.put(nums[i],i);
        }
        return ans;
    }
}

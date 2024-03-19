package Algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem40 {
    private List<List<Integer>> ans=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();
    private int sum=0;
    public static void main(String[] args) {

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);//O(n*logn)
        backTracking(candidates,target,0);
        return ans;
    }


    public void backTracking(int[] nums,int target,int index){
        if(sum==target){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(sum+nums[i]>target){//剪枝
                break;
            }
            sum+=nums[i];
            path.add(nums[i]);
            backTracking(nums,target,i+1);
            //回溯
            path.remove(path.size()-1);
            sum-=nums[i];
            //去重 要对同一树层使用过的元素进行跳过
            while(i<nums.length-1&&nums[i+1]==nums[i]){
                i++;
            }
        }
    }
}

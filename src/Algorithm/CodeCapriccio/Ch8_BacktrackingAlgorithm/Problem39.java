package Algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jmjtc
 * 组合总和
 */
public class Problem39 {
    private List<List<Integer>> ans=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();
    private int sum=0;
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Arrays.sort(candidates);
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
            //剪枝,需要先排序
            /*
            if(sum+nums[i]>target){
                break;
            }*/
            sum+=nums[i];
            path.add(nums[i]);
            backTracking(nums,target,index);
            //更新index
            index++;
            //回溯
            sum-=nums[i];
            path.remove(path.size()-1);
        }
    }
}

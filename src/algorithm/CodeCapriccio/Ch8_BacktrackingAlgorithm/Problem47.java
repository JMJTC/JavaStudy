package algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem47 {
    private List<List<Integer>> ans=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();
    private boolean[] used;
    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] nums){
        if(nums.length==0){
            return ans;
        }
        Arrays.sort(nums);
        used=new boolean[nums.length];
        backTacking(nums,0);
        return ans;
    }

    public void backTacking(int[] nums,int index){
        if(path.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            backTacking(nums,0);
            //回溯
            used[i]=false;
            path.remove(path.size()-1);
            //去重操作
            while(i<nums.length-1&&nums[i+1]==nums[i]){
                i++;
            }
        }
    }
}

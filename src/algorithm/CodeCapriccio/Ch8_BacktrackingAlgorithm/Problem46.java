package algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jmjtc
 */
public class Problem46 {
    private List<List<Integer>> ans=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();
    private Set<Integer> hashSet=new HashSet<>();
    public static void main(String[] args) {
        new Problem46().permute(new int[]{0,1});
    }

    public List<List<Integer>> permute(int[] nums){
        backTracking(nums,0);
        System.out.print(ans.toString());
        return ans;
    }

    public void backTracking(int[] nums,int startIndex){
        if(path.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            if(hashSet.contains(i)){
                continue;
            }else{
                hashSet.add(i);
                path.add(nums[i]);
            }
            backTracking(nums,0);
            path.remove(path.size()-1);
            hashSet.remove(i);
        }
    }
}

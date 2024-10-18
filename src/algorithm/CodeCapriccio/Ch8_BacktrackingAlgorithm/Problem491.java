package algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.*;

/**
 * @author jmjtc
 */
public class Problem491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    public void backTracking(int[] nums,int index){
        if(path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> hs=new HashSet<>();//每层使用一个set查重
        for(int i=index;i<nums.length;i++){
            if(!path.isEmpty() && path.get(path.size() -1 ) > nums[i] || hs.contains(nums[i])) {
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

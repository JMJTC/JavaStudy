package Algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.*;

/**
 * @author jmjtc
 */
public class Problem90 {
    List<List<Integer>> ans=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();

    public static void main(String[] args) {

    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Integer[] numsNew=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            numsNew[i]=nums[i];
        }
        Arrays.sort(numsNew, Comparator.comparingInt(o -> o));//先排序，方便去重，
        backTracking(numsNew,0);
        return ans;
    }

    public void backTracking(Integer[] nums,int index){

        ans.add(new ArrayList<>(path));

        //去重逻辑可优化

        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.removeLast();
            while(i< nums.length&&nums[i].equals(nums[i+1])){//去重
                i++;
            }
        }
    }
}

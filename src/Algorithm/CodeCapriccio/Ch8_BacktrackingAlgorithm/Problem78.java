package Algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem78 {
    List<List<Integer>> ans=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public static void main(String[] args) {
        new Problem78().subsets(new int[]{1,2,3});
    }

    public List<List<Integer>> subsets(int[] nums){
        for(int count=0;count<=nums.length;count++){
            backTracking(nums,0,count);
        }
        System.out.print(ans.toString());
        return ans;
    }

    public void backTracking(int[] nums,int index,int count){
        if(path.size()==count){
            ans.add(new ArrayList<>(path));
        }
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            backTracking(nums,i+1,count);
            path.removeLast();
        }
    }
}

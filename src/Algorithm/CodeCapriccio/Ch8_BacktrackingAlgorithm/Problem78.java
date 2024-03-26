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

        backTracking(nums,0);

        System.out.print(ans.toString());
        return ans;
    }

    public void backTracking(int[] nums,int index){
        ans.add(new ArrayList<>(path));
        if(index>=nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.removeLast();
        }
    }

    //利用二进制
    public List<List<Integer>> subsets2(int[] nums){
        for(int i=0;i<(1<<nums.length);i++){
            for(int j=0;j<nums.length;j++){
                if(((i>>j)&1)==1){
                    path.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(path));
            path.clear();
        }
        return ans;
    }
}

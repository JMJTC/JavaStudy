package algorithm.code_capriccio.Ch5_DoublePointMethod;

/**
 * @author jmjtc
 */
public class Problem027 {
    public int removeElement(int[] nums, int val){
        int left=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[left++]=nums[i];
            }
        }
        return left;
    }
}

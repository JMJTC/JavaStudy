package Algorithm.CodeCapriccio.Ch1_Array;

/**
 * @author jmjtc
 */
public class Problem26 {
    public static void main(String[] args) {

    }
}

class Problem26_Solution{
    public int removeDuplicates(int[] nums) {
        int left=1,right=1;
        int target=nums[0];
        while(right<nums.length){
            if(nums[right]!=target){
                nums[left++]=nums[right];
                target=nums[right];
            }
            right++;
        }
        return left;
    }
}

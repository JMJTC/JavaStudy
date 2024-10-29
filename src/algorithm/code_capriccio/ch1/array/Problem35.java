package algorithm.code_capriccio.ch1.array;

/**
 * @author jmjtc
 */
public class Problem35 {
    public static void main(String[] args) {

    }
}

//此题需要注意的是：考虑好边界情况
class Problem35_Solution{
    public int searchInsert(int[] nums, int target) {
        int length=nums.length;
        int left=0,right=length-1;
        while(left<right){
            int mid=left+((right-left)>>1);
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        if(nums[left]>=target){
            return left;
        }else{
            return left+1;
        }
    }
}

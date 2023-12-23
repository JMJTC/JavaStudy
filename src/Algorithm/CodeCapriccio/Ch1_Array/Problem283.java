package Algorithm.CodeCapriccio.Ch1_Array;

/**
 * @author jmjtc
 */
public class Problem283 {
    public static void main(String[] args) {

    }
}

class Problem283_Solution{
    public void moveZeroes(int[] nums) {
        int length=nums.length;
        int fast=0,slow=0;
        while(fast<length){
            if(nums[fast]!=0){
                nums[slow++]=nums[fast];
            }
            fast++;
        }
        while(slow<length){
            nums[slow++]=0;
        }
    }
}

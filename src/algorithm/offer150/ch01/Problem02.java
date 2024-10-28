package algorithm.offer150.ch01;

/**
 * @author jmjtc
 * <a href="https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Problem02 {
    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[ans++]=nums[i];
            }
        }
        return ans;
    }
}

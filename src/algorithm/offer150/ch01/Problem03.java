package algorithm.offer150.ch01;

/**
 * @author jmjtc
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Problem03 {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(i==0||nums[i]!=nums[i-1]){
                nums[ans++]=nums[i];
            }
        }
        return ans;
    }
}

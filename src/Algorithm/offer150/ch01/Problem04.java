package Algorithm.offer150.ch01;

/**
 * @author jmjtc
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Problem04 {
    public static void main(String[] args) {
        new Problem04().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
    }
    public int removeDuplicates(int[] nums) {
        int left=0;
        for(int i=0;i<nums.length;i++){
            int count=1;
            nums[left++]=nums[i];
            boolean flag=false;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==nums[j-1]){
                    count++;
                    if(count<=2){
                        nums[left++]=nums[j];
                    }
                }else{
                    i=j-1;
                    break;
                }
                if(j==nums.length-1){
                    flag=true;
                }
            }
            if(flag){
                break;
            }
        }
        return left;
    }
}

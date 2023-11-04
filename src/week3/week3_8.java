package week3;

/**
 * @author jmjtc
 */
public class week3_8 {
    public static void main(String[] args){
        int[] nums=new int[]{1,2,3,4,5,6,7};
        System.out.println(new Solution().findPeakElement(nums));
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int i=nums.length/2;
        int max=nums.length;
        int min=0;
        while(i>0&&i<nums.length-1&&(nums[i]<nums[i+1]||nums[i]<nums[i-1])){
            if(nums[i]<nums[i+1]){
                min=i;
                i=(max+i)/2;
                continue;
            }
            if(nums[i]<nums[i-1]){
                max=i;
                i=(min+i)/2;
            }
        }
        //边界情况需要再判断一次
        if(i==1){
            return nums[i]>nums[i-1]?i:i-1;
        }
        if(i==nums.length-2){
            return nums[i]>nums[i+1]?i:i+1;
        }
        return i;
    }
}

package EveryWeekStudy.week4;

/**
 * @author jmjtc
 */
public class week4_13 {
    public static int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid;
        while(left<right){
            mid=(right-left>>1)+left;
            if(nums[mid]>target){
                right=mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                left=right=mid;
                break;
            }
        }
        if(nums.length==0||nums[left]!=target){
            return new int[]{-1,-1};
        }else{
            int beg=left,end=left;
            while(left<nums.length-1&&nums[++left]==target){
                end=left;
            }
            while(right>0&&nums[--right]==target){
                beg=right;
            }
            return new int[]{beg,end};
        }
    }
    public static void main(String[] args){
        searchRange(new int[]{5,7,7,8,8,10},8);
    }
}

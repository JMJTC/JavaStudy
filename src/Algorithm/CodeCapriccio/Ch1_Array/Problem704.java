package Algorithm.CodeCapriccio.Ch1_Array;

/**
 * @author jmjtc
 */
public class Problem704 {
    public static void main(String[] args) {

    }
}
//二分查找 两种写法
//1.左闭右闭[left,right]
//2.左闭右开[left,right)
class Problem704_Solution {
    public int search(int[] nums, int target) {
        int length=nums.length;
        int left=0,right=length-1;
        while(left<right){
            int mid=left+(right-left)/2;//取小整
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        if(nums[left]==target){
            return left;
        }else{
            return -1;
        }
    }
}

package algorithm.CodeCapriccio.Ch1_Array;

/**
 * @author jmjtc
 */
public class Problem977 {
    public static void main(String[] args) {

    }
}

//还可以这样想，平方后最大的数一定出现在两端，因此可以定义一个双指针，left=0,right=length-1,每次选一个的数放入数组尾端，妙呀
class Problem977_Solution{
    public int[] sortedSquares(int[] nums) {
        int i=0;
        for(i=0;i<nums.length&&nums[i]<0;i++){
            nums[i]=-nums[i];
        }
        //找分界点，该点左右两边都是有序的
        int left=i-1,right=i;
        int index=0;
        int[] ans=new int[nums.length];
        while(left>=0&&right<nums.length){
            if(nums[left]<nums[right]){
                ans[index++]=nums[left]*nums[left];
                left--;
            }else{
                ans[index++]=nums[right]*nums[right];
                right++;
            }
        }
        while(left>=0){
            ans[index++]=nums[left]*nums[left];
            left--;
        }
        while(right<nums.length){
            ans[index++]=nums[right]*nums[right];
            right++;
        }
        return ans;
    }
}

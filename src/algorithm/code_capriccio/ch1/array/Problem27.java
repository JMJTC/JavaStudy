package algorithm.code_capriccio.ch1.array;

/**
 * @author jmjtc
 */
public class Problem27 {
    public static void main(String[] args) {

    }
}

//两层for循环,时间复杂度O(n^2)
class Problem27_Solution1{
    public int removeElement(int[] nums, int val) {
        int ans=nums.length;
        for(int i=0;i<ans;){
            if(nums[i]==val){
                for(int j=i;j<ans-1;j++){
                    nums[j]=nums[j+1];
                }
                ans--;
            }else{
                i++;
            }
        }
        return ans;
    }
}


//双指针法,时间复杂度O(n)，快慢指针
class Problem27_Solution2{
    public int removeElement(int[] nums, int val){
        int left=0,right=0;
        while(right<nums.length){
            if(nums[right]!=val){
                nums[left++]=nums[right];
            }
            right++;
        }
        return left;
    }
}
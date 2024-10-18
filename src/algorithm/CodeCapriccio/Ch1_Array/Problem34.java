package algorithm.CodeCapriccio.Ch1_Array;

/**
 * @author jmjtc
 */
public class Problem34 {
    public static void main(String[] args) {

    }
}

//方一：先找到任一target值，再左右搜索，时间复杂度介于 log(n)到n
class Problem34_Solution1{
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[]{-1,-1};
        int length=nums.length;
        if(length==0){
            return ans;
        }
        int left=0,right=length-1;
        while(left<right){
            int mid=left+((right-left)>>1);
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        if(nums[left]==target){
            while(left>=0&&nums[left]==target){
                left--;
            }
            while(right<length&&nums[right]==target){
                right++;
            }
            return new int[]{left+1,right-1};
        }else{
            return ans;
        }
    }
}

//方法二：两个二分,时间复杂度：O(log(n))
//还可以优化，代码重用，把寻找左右区间的函数合并在一起
class Problem34_Solution{
    public int[] searchRange(int[] nums, int target){
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int leftIndex=findLeftIndex(nums,target);
        int rightIndex=findRightIndex(nums,target);
        if(leftIndex==-1){
            return new int[]{-1,-1};
        }
        return new int[]{leftIndex,rightIndex};
    }

    public int findLeftIndex(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+((right-left)>>1);//取小整
            if(nums[mid]>=target){
                right=mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        if(nums[left]==target){
            return left;
        }else{
            return -1;
        }
    }

    public int findRightIndex(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(right>left){
            int mid=right-((right-left)>>1);//取大整
            if(nums[mid]<=target){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        if(nums[right]==target){
            return right;
        }else{
            return -1;
        }
    }
}
package algorithm.code_capriccio.Ch1_Array;

import java.util.Arrays;

/**
 * @author jmjtc
 */
public class Problem209 {
    public static void main(String[] args) {
        int target=7;
        int[] nums=new int[]{2,3,1,2,4,3};
        System.out.println(new Problem209_Solution1().minSubArrayLen1(target,nums));
    }
}

//滑动窗口
//避免了双层for循环,将时间复杂度降为O(n)
class Problem209_Solution1{
    public int minSubArrayLen(int target, int[] nums) {
        int min=nums.length;
        int sum=0;
        int fast=0,slow=0;
        boolean flag=false;
        while(true){
            boolean ifChange=true;
            if(sum>=target){
                flag=true;
                if(sum-nums[slow]>=target){
                    ifChange=false;
                    sum-=nums[slow++];
                }
                if(min>fast-slow){
                    min=fast-slow;
                }
            }
            if(ifChange){
                if(fast>=nums.length){
                    break;
                }
                sum+=nums[fast++];
            }
        }
        if(flag){
            return min;
        }else{
            return 0;
        }
    }


    //优化后的代码
    public  int minSubArrayLen1(int target, int[] nums){
        int ans=Integer.MAX_VALUE;
        int slow=0,fast=0;
        int sum=0;
        while(fast<nums.length){
            sum+=nums[fast++];
            while(sum>=target){
                ans=Math.min(ans,fast-slow);
                sum-=nums[slow++];
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}

//前缀和+二分查找
class Problem209_Solution2{
    public  int minSubArrayLen(int target, int[] nums){
        int ans=Integer.MAX_VALUE;
        int[] sum=new int[nums.length+1];
        //数组长度定义为nums.length+1，sum[0]=0,方便计算
        for(int i=1;i<nums.length+1;i++){
            sum[i]=sum[i-1]+nums[i-1];
        }
        //对每一个前缀和进行二分查找
        for(int i=1;i<nums.length+1;i++){
            int newTarget=target+sum[i-1];
            int index= Arrays.binarySearch(sum,newTarget);//二分查找
            if(index<0){
                index=-index-1;
            }
            if(index<nums.length+1){
                ans=Math.min(ans,index-(i-1));
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
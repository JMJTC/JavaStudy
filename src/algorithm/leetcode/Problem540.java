package algorithm.leetcode;

import algorithm.code_capriccio.ch1.array.Problem54;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-10
 * @Description: 540. 有序数组中的单一元素
 * @Version: 1.0
 */


public class Problem540 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,2,2,3};
        System.out.println(new Problem540().singleNonDuplicate1(nums));
    }


    //时间复杂度：O(n)
    public int singleNonDuplicate(int[] nums) {
        int length=nums.length;
        for(int i=0;i+1<length;i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[length-1];
    }

    //时间复杂度:O(log n) 二分查找
    public int singleNonDuplicate1(int[] nums){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=(left+right)>>1;//相当于取小整
            int count=mid-left;
            //mid 左右的数的个数相同
            if(nums[mid]==nums[mid-1]){
                if(count%2==0){
                    right=mid-2;
                }else{
                    left=mid+1;
                }
            }else if(nums[mid]==nums[mid+1]){
                if(count%2==0){
                    left=mid+2;
                }else{
                    right=mid-1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[left];
    }
}

package EveryWeekStudy.week4;

public class week4_3 {
    public static void main(String[] args){

    }
}

class SolutionQuestion3 {
    public int searchInsert(int[] nums, int target) {
        int ans=0;
        int ways=2;
        for(ans=0;ans<nums.length;ans++){
            if(nums[ans]>=target){
                ways=0;
                break;
            }

        }

        return ways!=2?ans:nums.length;
    }

    public int searchInsertWithDichotomy(int[] nums,int target){
        int n=nums.length;
        int left=0,right=n-1,ans=n;
        while(left<=right){
            //向上取整
            int mid=(right+left)>>1;
            //mid=(right+left)>>>1,规避整形溢出
            //or  mid=(right-left>>1)+left
            if(target<=nums[mid]){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}
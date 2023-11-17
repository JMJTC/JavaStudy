package week5;

public class week5_6 {
}


//暴力遍历，超时
class week5_6_Solution1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        //方一：暴力遍历
        int length=nums.length;
        for(int i=0;i<length;i++){
            int sum=nums[i];
            for(int j=i+1;j<length;j++){
                sum+=nums[j];
                if(sum%k==0){
                    return true;
                }
            }
        }
        return false;
    }
}

class week5_6_Solution2{
    
}

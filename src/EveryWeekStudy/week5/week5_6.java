package EveryWeekStudy.week5;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jmjtc
 */
public class week5_6 {
    public static void main(String[] args){
        int[] nums=new int[]{0,0};
        System.out.println(new week5_6_Solution2().checkSubarraySum(nums,1));
    }
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
    public boolean checkSubarraySum(int[] nums, int k) {
        int length=nums.length;
        for(int i=2;i<=length;i++){
            for(int j=0;j<length-i+1;j++){
                int sum=0;
                for(int z=0;z<i;z++){
                    sum+=nums[j+z];
                }
                if(sum%k==0||sum==0){
                    return true;
                }
            }
        }
        return false;
    }
}

class week5_6_Solution3{
    public boolean checkSubarraySum(int[] nums, int k) {
        int length=nums.length;
        //sums记录前缀和
        int[] sums=new int[length+1];
        //初始化
        for(int i=1;i<=length;i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
        Set<Integer> set=new HashSet<>();//无序，唯一
        //sums[i],sums[j]对k取余相同时，sums[j]-sums[i]是k的倍数，i-j>=2时，返回true
        for(int i=2;i<=length;i++){
            set.add(sums[i-2]%k);
            if(set.contains(sums[i]%k)){
                return true;
            }
        }
        return false;
    }
}

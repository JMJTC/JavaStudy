package algorithm.code_capriccio.Ch5_DoublePointMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem018 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int length=nums.length;
        for(int i=0;i<length;i++){
            //对i去重
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            long newTarget=target-nums[i];
            for(int j=i+1;j<length-2;j++){
                //对j去重
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int l=j+1,r=length-1;
                while(l<r){
                    if((long)nums[j]+nums[l]+nums[r]==newTarget){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[r],nums[l]));
                        l++;
                        r--;
                        //找到后对l,r去重
                        while(l<r&&nums[l]==nums[l-1]){
                            l++;
                        }
                        while(l<r&&nums[r]==nums[r+1]){
                            r--;
                        }
                    }else if((long)nums[j]+nums[l]+nums[r]>newTarget){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}

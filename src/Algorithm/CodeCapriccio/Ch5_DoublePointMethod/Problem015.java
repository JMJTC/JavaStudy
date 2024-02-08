package Algorithm.CodeCapriccio.Ch5_DoublePointMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem015 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        int i=0,j=1,k=2;

        if(nums[i]+nums[j]+nums[k]>0){
            return ans;
        }

        int length=nums.length;

        for(i=0;i<length-2;i++) {
            if (nums[i] > 0) {
                break;
            }

            //对i去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            j=i+1;k=length-1;
            while(j<k){
                /*if(j>i+1&&nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                if(k<length-1&&nums[k]==nums[k+1]){
                    k--;
                    continue;
                }*/
                if(nums[i]+nums[j]+nums[k]==0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    //去重逻辑应在找到一个三元组之后
                    j++;k--;
                    while(j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                    while(j<k&&nums[k]==nums[k+1]){
                        k--;
                    }
                }else if(nums[i]+nums[k]+nums[j]<0){
                    j++;
                }else{
                    k--;
                }
            }

        }
        return ans;
    }
}

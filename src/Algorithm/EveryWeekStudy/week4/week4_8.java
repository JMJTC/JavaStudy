package Algorithm.EveryWeekStudy.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class week4_8 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        int sum=1<<length;
        //List<Integer> temp0=new ArrayList<>();
        //ans.add(temp0);
        for(int i=0;i<sum;i++){
            List<Integer> temp1=new ArrayList<>();
            for(int j=0;j<length;j++){
                if(((i>>j)&1)==1){
                    temp1.add(nums[j]);
                }
            }
            if(!ans.contains(temp1)){
                ans.add(temp1);
            }
        }
        return ans;
    }
}

package EveryWeekStudy.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week5_1 {
    public void main (Scanner sc){
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        new week5_1_Solution().threeSum(nums);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        new week5_1().main(sc);
    }
}

class week5_1_Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        //采用双指针法，需要先做排序操作
        Arrays.sort(nums);
        int length=nums.length;
        for(int i=0;i<length;i++){
            //初始化
            int left=i+1;
            int right=length-1;
            //对i去重
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            //终止条件：left==right
            while(left<right){
                if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    //对rigth,left去重，剪枝
//                    List<Integer> temp=new ArrayList<>();
//                    temp.add(nums[i]);
//                    temp.add(nums[left]);
//                    temp.add(nums[right]);
//                    res.add(temp);
                    res.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}

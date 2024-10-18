package algorithm.EveryWeekStudy.week4;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week4_2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(new Solution().missingNumber(nums));
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int[] record=new int[nums.length+1];
        for(int i:nums){
            record[i]=1;
        }
        int ans=0;
        for(int i=0;i<record.length;i++){
            if(record[i]==0){
                ans=i;
                break;
            }
        }
        return ans;
    }
}
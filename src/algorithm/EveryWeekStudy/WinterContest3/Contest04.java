package algorithm.EveryWeekStudy.WinterContest3;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest04 {
    public static int minimumOperand(int[] nums,int target){
        int ans=-1;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum<target){
            return ans;
        }
        int left=0,right=0;
        target=sum-target;
        sum=0;
        for(right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left++];
            }
            if(sum==target){
                ans=Math.max(ans,right-left+1);
            }
        }
        return ans==-1?-1:nums.length-ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            int length=sc.nextInt();
            int target=sc.nextInt();
            int[] nums=new int[length];
            for(int j=0;j<length;j++){
                nums[j]=sc.nextInt();
            }
            System.out.println(minimumOperand(nums,target));
        }
    }
}

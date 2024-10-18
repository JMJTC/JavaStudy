package algorithm.EveryWeekStudy.WinterContest3;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest06 {
    public static int maximumProfit(int[]nums){
        int ans=0;
        int l=0,r=1;
        while(r<nums.length){
            if(nums[r]>nums[l]){
                ans+=nums[r]-nums[l];
            }
            l++;
            r++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(maximumProfit(nums));
    }
}

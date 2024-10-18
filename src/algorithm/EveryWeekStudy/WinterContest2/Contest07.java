package algorithm.EveryWeekStudy.WinterContest2;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest07 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int l=0,r=0;
        int count=0;
        for(int i=0;i<n-1;i++){
            if(nums[i+1]>nums[i]){
                count++;
                r=i+1;
            }else{
                l=r=i+1;
            }
            if(count!=0&&count%2==0){
                System.out.print(nums[i+1]+' ');
            }
        }
    }
}

package algorithm.everyweekstudy.WinterContest3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest01 {
    public static boolean canSort(int[] nums){
        int length=nums.length;
        for(int i=0;i<length;){
            int start=i;
            int ones=Integer.bitCount(nums[i++]);
            while(i<length&&ones==Integer.bitCount(nums[i])){
                i++;
            }
            Arrays.sort(nums,start,i);
        }
        for(int i=1;i<length;i++){
            if(nums[i]<nums[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int length=sc.nextInt();
            int[] nums=new int[length];
            for(int j=0;j<length;j++){
                nums[j]=sc.nextInt();
            }
            if(canSort(nums)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}

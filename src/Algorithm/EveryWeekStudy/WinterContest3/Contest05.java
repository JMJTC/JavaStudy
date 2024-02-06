package Algorithm.EveryWeekStudy.WinterContest3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest05 {
    public static int miniNumsLength(int[] nums){
        Arrays.sort(nums);
        int count=1;
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==min){
                count++;
            }else{
                if(nums[i]%min!=0){
                    return 1;
                }
            }
        }
        return (count+1)/2;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            int length=sc.nextInt();
            int[] nums=new int[length];
            for(int j=0;j<length;j++){
                nums[j]=sc.nextInt();
            }
            System.out.println(miniNumsLength(nums));
        }
    }
}

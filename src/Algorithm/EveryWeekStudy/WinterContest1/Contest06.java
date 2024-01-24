package Algorithm.EveryWeekStudy.WinterContest1;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest06 {
    public static int maxOfSum(int[] data){
        int sum = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : data) {
            temp += num;
            sum = Math.max(sum, temp);
            //连续和为负数时 就重置
            if (temp <= 0) {
                temp = 0;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] data=new int[n];
        for(int i=0;i<n;i++){
            data[i]=sc.nextInt();
        }

        System.out.println(maxOfSum(data));
    }
}

package Algorithm.EveryWeekStudy.WinterContest2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest01 {
    public static long leaveMinBeans(int[] beans){
        long ans=0,sum=0;
        Arrays.sort(beans);
        for(int i=0;i<beans.length;i++){
            sum+=beans[i];
            //找出最多能剩多少
            ans=Math.max(ans,(long)(beans.length-i)*beans[i]);
        }
        return sum-ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] beans=new int[n];
        for(int i=0;i<n;i++){
            beans[i]=sc.nextInt();
        }
        System.out.println(leaveMinBeans(beans));
    }
}

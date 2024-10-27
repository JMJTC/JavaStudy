package algorithm.everyweekstudy.WinterContest3;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest02 {
    public static long[] apples=new long[125992+1];
    public static long getSum(long ans){
        long sum=0;
//        while(ans>=2){
//            long temp=ans,tempSum=0;
//            tempSum=(temp+temp/2)*(temp/2+1)-temp-temp/2;
//            tempSum*=4;
//            sum+=tempSum;
//            ans-=2;
//        }
        long tempSum=0;
        tempSum=(ans + ans /2)*(ans /2+1)- ans - ans /2;
        tempSum*=4;
        sum+=tempSum;
        return sum+apples[(int)ans-2];
    }
    public static long getPerimeter(long apple){
        long l=2,r=125992;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(mid%2!=0){
                mid+=1;
            }
            if(apples[(int)mid]>=apple){
                r=mid-2;
            }else{
                l=mid+2;
            }
        }
        return l*4;
    }
    public static void solve(Scanner sc){
//        //初始化apples
//        for(int i=2;i<=apples.length;i+=2){
//            apples[i]=getSum(i);
//        }
//        int n=sc.nextInt();
//        for(int i=0;i<n;i++){
//            System.out.println(getPerimeter(sc.nextLong()));
//        }


        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println(minimumPerimeter(sc.nextLong()));
        }
    }
    public static long minimumPerimeter(long neededApples) {
        long left = 1, right = 100000, ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (2 * mid * (mid + 1) * (mid * 2 + 1) >= neededApples) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans * 8;
    }
    public static void main(String[] args) {
        //System.out.println(getSum(4));
        Scanner sc=new Scanner(System.in);
        solve(sc);
    }
}

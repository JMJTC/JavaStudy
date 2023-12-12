package EveryWeekStudy.week4;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week4_12 {
    public static boolean isHuiWen(int a,int b){
//        int n=a.length;
//        int[] temp=new int[n];
//        int cnt=0;
//        for(int i=0;i<n;i++){
//            temp[i]=a[i]+b[i];
//            if(temp[i]%2!=0){
//                cnt++;
//            }
//        }
//        return cnt < 2;
        int mask=a^b;
        return mask==0||(mask&(mask-1))==0;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] data=new String[n];
        for(int i=0;i<n;i++){
            data[i]=sc.next();
        }
        //统计字符串中每个字母出现的次数(记录其奇偶性即可)
        int[] dataCount=new int[n];
        for(int i=0;i<n;i++){
            int length=data[i].length();
            for(int j=0;j<length;j++){
                dataCount[i]=dataCount[i]^(1<<data[i].charAt(j)-'a');
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isHuiWen(dataCount[i],dataCount[j])){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}

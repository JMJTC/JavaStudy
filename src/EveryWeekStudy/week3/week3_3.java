package EveryWeekStudy.week3;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week3_3 {
//    public static int ysf(int n,int k){
//        if(n==1){
//            return (k-1+n)%n;
//        }
//        else{
//            return (ysf(n-1,k)+k)%n;
//        }
//    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),k=in.nextInt();
        int ans=0;
        //递归调用太多会导致堆栈溢出，因此这里选择将递归变为for循环
        for(int i=1,temp=0;i<=n;i++){
            ans=(temp+k)%i;
            temp=ans;
        }
        System.out.println(ans+1);
    }
}

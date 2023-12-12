package EveryWeekStudy.week2;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week2_5 {

//    public static void dictionary(int n){
//        int i, j, k, t1=0, b;
//        char[]a= new char[]{'0','1','2','3','4','5','6','7','8','9'};
//        char min, t2;
//        int len = 10;
//        for (i = 1; i < n; i++)
//        {
//            min = 'z';
//            for (j = len - 2; j >= 0; j--)
//            {
//                if (a[j] < a[j + 1])
//                {
//                    for (k = j + 1; k < len; k++)
//                    {
//                        if (a[k] > a[j])
//                        {
//                            if (min > a[k])
//                            {
//                                min = a[k];
//                                t1 = k;
//                            }
//                        }
//                    }
//                    t2 = a[j];
//                    a[j] = a[t1];
//                    a[t1] = t2;
//                    for (k = j + 1, b = len - 1; k <= b; k++, b--)
//                    {
//                        t2 = a[k];
//                        a[k] = a[b];
//                        a[b] = t2;
//                    }
//                    break;//跳出循环，进行下一次排列
//                }
//            }
//        }
//        String temp=new String(a);
//        System.out.println(String.valueOf(temp));
//    }
    //动态规划
//假设要求从零到九的数构成的字符串S形成的字典排列中的第n位，记为lp(n,s)，字符串的长度为len(s)
//设q=n/(len(s)−1)!, r=n%(len(s)−1)!
//则我们可以将动态规划的状态转移方程表述为：
//lp(n,s)={s[q]+lp(r,s[:q]+s[q+1:])  len(s)>1
//s                                   len(s)=1
    public static String dictionary(int n,String data){

        if(data.length()>1){
            int t=fact(data.length()-1);
            int q=n/t;
            int r=n%t;
            return data.charAt(q)+dictionary(r,data.substring(0,q)+data.substring(q+1));
        }
        else{
            return data;
        }
    }
    public static int fact(int n){
        if(n==1){
            return 1;
        }
        else{
            return n*fact(n-1);
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int length=fact(10);
        String data= "0123456789";
        for(int i=0;i<n;i++){
            if(arr[i]>length){
                System.out.println("WustJavaClub");
            }
            else{
                String ars=dictionary(arr[i]-1,data);
                System.out.println(ars);
            }
        }

    }
}

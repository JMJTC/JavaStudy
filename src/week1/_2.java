package week1;

import java.util.Scanner;
public class _2 {
    public static void main(String[] args){
        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        int sum=0,count=0;
        int first=0,second=1,temp;
        for(;first+second<=n;){
            temp=first+second;
            count++;
            if(count%3==2){
                sum+=temp;
            }
            first=second;
            second=temp;
        }
        System.out.println(sum);
    }
}

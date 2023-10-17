package week1;

import java.util.Scanner;
public class _4 {
    public static boolean IsHuiwen(int t){
        short count=1;
        int T=t;
        int ten=10;
        while(T>=ten){
            ten*=10;
            count++;
        }
        int temp=0;
        for(int i=0;i<count;i++){
            temp=temp*10+T%10;
            T/=10;
        }
        if(temp==t)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        short n;
        int answer=0;
        Scanner in=new Scanner(System.in);
        n= in.nextShort();
        int MAX=1;
        for(int i=0;i<n;i++){
            MAX*=10;
        }
        int max=MAX/10;
        MAX--;
        int another=MAX-1;
        while(MAX>=max){
            if(IsHuiwen(MAX*another)&&answer<MAX*another){
                answer=MAX*another;
            }

            another--;
            if(another<max){
                MAX--;

                another=MAX-1;
            }
        }

        System.out.println(answer);
        //System.out.println(MAX);
        //System.out.println(another);
    }
}

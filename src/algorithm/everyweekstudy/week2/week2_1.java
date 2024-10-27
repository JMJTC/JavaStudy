package algorithm.everyweekstudy.week2;

import java.util.Scanner;
import static java.lang.Math.pow;
public class week2_1 {
    public static void main(String[] args){
        long square1=0L,square2=0L;
        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        for(int i=1;i<=n;i++){
            square1+=(long)pow(i,2);
        }
        int temp=(1+n)*n/2;//求前n项和
        square2=(long)pow(temp,2);
        System.out.println(square2-square1);
    }
}

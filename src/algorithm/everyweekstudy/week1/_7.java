package algorithm.everyweekstudy.week1;

import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class _7 {
     public static boolean IsExceed(int triang,short n){
        short count=0;
        for(short i=1;i<=sqrt(triang);i++){
            if(triang%i==0)
                count+=2;
        }
        double temp=sqrt(triang);
        if(abs(temp*temp-triang)<0.000001)
            count--;
         return count < n;
    }
    public static void main(String[] args){
        short n;
        Scanner in=new Scanner(System.in);
        n=in.nextShort();
        int triangular_number=1;
        for(int i=2;IsExceed(triangular_number,n);i++){
            triangular_number+=i;
        }
        System.out.println(triangular_number);
    }
}

package algorithm.EveryWeekStudy.week1;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class _10_22_5 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int left1,left2,right2,right1;
        left1=in.nextInt();
        right1=in.nextInt();
        left2=in.nextInt();
        right2=in.nextShort();
        Set<BigInteger> set=new HashSet<>();//HashSet去重
        for(int i=left1;i<=right1;i++){
            for(int j=left2;j<=right2;j++){
                set.add(BigInteger.valueOf(i).pow(j));
            }
        }
        System.out.println(set.size());

    }
}

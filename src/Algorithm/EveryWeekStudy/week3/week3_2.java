package Algorithm.EveryWeekStudy.week3;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week3_2 {
    public static void main(String[] args){
        //An=An-1+n 由该式可直接推导出An的式子，避免递归
        Scanner in=new Scanner(System.in);
        //由题目的测试数据可知,应选择long型
        long n=in.nextLong();
        if(n==0){
            System.out.println(1);
        }
        else{
            long ans=(n-1)*(n+2)/2+2;
            System.out.println(ans);
        }

    }
}

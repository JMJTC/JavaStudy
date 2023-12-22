package Algorithm.EveryWeekStudy.week1;

import java.math.BigInteger;
import java.util.Scanner;

//利用大数工具类
public class _10_22_1 {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();//跳过换行符
        BigInteger ans=new BigInteger(scanner.nextLine());
        for(int i=1;i<t;i++){
            ans=ans.add(new BigInteger(scanner.nextLine()));
        }
        String ansStr=ans.toString();
        System.out.println(ansStr.substring(0,10));//substring截取子串
//        while (t-- > 0) {
//            String a = scanner.next();
//            BigInteger bigNum1 = new BigInteger(a);
//
//
//            System.out.flush();
//        }
    }

}

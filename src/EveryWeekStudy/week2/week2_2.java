package EveryWeekStudy.week2;

//import java.math.BigInteger;
import java.util.Scanner;

public class week2_2 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int len=in.nextInt();
        in.nextLine();//若不写这一行，s所读入的长度就会为0，结果会显示运行错误RE
//        BigInteger str=new BigInteger(in.nextLine());  //多余了，此题用不到
        String str=in.nextLine();
        int n=in.nextInt();
        int count=len-n+1;//计算的次数
        long max=0L;//选择长整型，防止溢出

        for(int i=0;i<count;i++){
           long temp=1;
           for(int j=0;j<n;j++){
               String x=str.substring(i+j,i+j+1);//获取子串
               temp*=Integer.parseInt(x);//获取第i+j个数字，转化成int型
           }
           if(temp>max){
               max=temp;
           }
        }
        System.out.println(max);
    }
}

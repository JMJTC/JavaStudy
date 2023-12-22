package Algorithm.EveryWeekStudy.week1;

import java.util.Scanner;

public class _5 {
//    1、分解质因数法
//    先把这几个数的质因数写出来，最小公倍数等于它们所有的质因数的乘积（如果有几个质因数相同，则比较两数中哪个数有该质因数的个数较多，乘较多的次数）。
//    比如求45和30的最小公倍数。
//            45=3*3*5
//            30=2*3*5
//    不同的质因数是2。5，3是他们两者都有的质因数，由于45有两个3，30只有一个3，所以计算最小公倍数的时候乘两个3.
    public static void main(String [] args){
        short n;
        Scanner in=new Scanner(System.in);
        n=in.nextShort();
        short[] data=new short[n];
        short[] prime=new short[41];
        short count_prime=0;
        short miniprime=2;
        //初始化data
        for(short i=0;i<data.length;i++){
            data[i]= (short) (i+1);
        }
        boolean IsTrue;
        boolean test=true;
        while(test){
            IsTrue=false;
            for(short i=0;i<n;i++){
                if(data[i]%miniprime==0){
                    data[i]/=miniprime;

                    IsTrue=true;
                }
            }
            if(IsTrue==false){
               short i=0;
               while(data[i]==1){
                   i++;
                   if(i==n){//最后一项也为1时跳出
                       test=false;
                       break;
                   }
               }
               if(test){
                   miniprime=data[i];//该数一定为质数
               }


            }
            else
                prime[count_prime++]=miniprime;//记录质因数
        }
        long answer=1;
        for(int i=0;i<count_prime;i++){
            answer*=prime[i];
        }
        System.out.println(answer);


    }
}

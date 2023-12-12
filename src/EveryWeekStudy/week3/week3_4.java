package EveryWeekStudy.week3;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week3_4 {
    //求最小公倍数,以知a和b两个数，最小公倍数 = （a*b）/ 最大公约数
    //利用辗转相除法
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }
    public static int minMultiply(int a,int b){
        int t=gcd(a,b);
        return (a*b)/t;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt();
        int[] data=new int[m];
        for(int i=0;i<m;i++){
            data[i]=in.nextInt();
        }
        int ans=0;//满足条件的个数
        //枚举区间是[1,2^m-1]，奇加偶减
        for(int i=1;i<(1<<m);i++)
        {
            int t=1;     //选中集合对应数的最小公倍数
            int cnt=0;  //选中的集合数量
            //枚举当前状态的每一位
            for(int j=0;j<m;j++)    //判断这m个二进制位
            {
                if((i>>j&1)==1)//如果该二进制位是1
                {
                    //乘积大于n, 则n/t = 0, 跳出这轮循环
                    //tips:选择long型，否则会有溢出的可能
                    if((long)t*(long)data[j]>n)
                    {
                        t=-1;
                        break;
                    }
                    cnt++;       //有一个1，集合数量+1
                    t=minMultiply(t,data[j]);
                }
            }
            if(t==-1) {
                continue;
            }
            //选中奇数个集合, 由容斥原理公式可知,前面符号是正号+, n/t为当前这种状态的集合数量
            if((cnt&1)==1) {
                ans+=n/t;
            }
            //选中偶数个集合, 由容斥原理公式可知,前面符号是负号-, n/t为当前这种状态的集合数量
            else {
                ans-=n/t;
            }
        }

        System.out.println(ans);
    }
}

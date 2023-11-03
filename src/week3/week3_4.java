package week3;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class week3_4 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt();
        int[] data=new int[m];
        for(int i=0;i<m;i++){
            data[i]=in.nextInt();
        }
        //but这些数不一定为质数，需要先变为质数，或者用别的方法，这题提交后有一个WA
        int ans=0;//满足条件的个数
        //枚举区间是[1,2^m-1]，奇加偶减
        for(int i=1;i<(1<<m);i++)
        {
            int t=1;     //选中集合对应质数的乘积
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
                    t*=data[j];
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

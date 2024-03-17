package Algorithm.ContestLan._14th;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class C_ArraySegmentation {
    private static final int MOD = 1000000007;
    static int x,y;
    public static void main(String[] args) {
        //System.out.println(quickPow(2,500));
        //System.out.println(pim(500));
        //System.out.println(Integer.MAX_VALUE);
        Scanner sc=new Scanner(System.in);
        int t;//t组数据
        t=sc.nextInt();
        for(int i=0;i<t;i++){
            input(sc);
            System.out.println(getDifferentR());
        }
    }

    public static long getDifferentR(){
        long ans=0;
        if(x%2==0){
            ans=quickPow(2,x==0?0:x-1)*quickPow(2,y)%MOD;
            //ans = pim(y) * pim(x == 0 ? 0 : x - 1) % MOD;
        }
        return ans%MOD;
    }
    static long pim(long b) {
        if (b == -1) return 1;
        long t = 2, res = 1;
        while (b != 0) {
            if ((b & 1) == 1) res = res * t % MOD;
            t = t * t % MOD;
            b >>= 1;
        }
        return res % MOD;
    }

    //快速幂
    public static long quickPow(long a,long n){
        long ans=1;
        while(n>0){
            if((n&1)==1){//当前末位为一
                ans=(ans*a)%MOD;
            }
            a=(a*a)%MOD;
            n>>=1;//n右移一位
        }
        return ans%MOD;
    }

    public static void input(Scanner sc){
        int n=sc.nextInt();
        x=0;y=0;
        for(int i=0;i<n;i++){
            if(sc.nextInt()%2==0){
                y++;
            }else{
                x++;
            }
        }
    }
}

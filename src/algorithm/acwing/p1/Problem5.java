package algorithm.acwing.p1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-27
 * @Description: 5. 多重背包问题 II
 * @Version: 1.0
 */
public class Problem5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int v,w,k;
        List<Good> goods=new ArrayList<>();
        for(int i=0;i<n;i++){
            s=br.readLine().split(" ");
            v=Integer.parseInt(s[0]);
            w=Integer.parseInt(s[1]);
            k=Integer.parseInt(s[2]);
            for(int j=1;j<=k;j*=2){
                k-=j;
                goods.add(new Good(v*j,w*j));
            }
            if(k>0){
                goods.add(new Good(v*k,w*k));
            }
        }

        //dp
        int[] dp=new int[m+1];
        for(Good good:goods){
            for(int j=m;j>=good.getV();j--){
                dp[j]=Math.max(dp[j],dp[j-good.getV()]+ good.getW());
            }
        }
        bw.write(dp[m]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Good{
    int v;
    int w;
    public Good(int v,int w){
        this.v=v;
        this.w=w;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }
}

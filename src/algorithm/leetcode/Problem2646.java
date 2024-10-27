package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem2646 {
    public static void main(String[] args) {

    }
}


class Problem2477Solution {
    private List<Integer>[] g;
    private int[] price,cnt;
    private int end;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        g=new ArrayList[n];
        Arrays.setAll(g, e->new ArrayList<>());
        //建树,也可以说是用领接表建图
        for(int[]e:edges){
            int x=e[0],y=e[1];
            g[x].add(y);
            g[y].add(x);
        }

        //计算每个点会经过多少次
        cnt=new int[n];
        for(int[]t: trips){
            end=t[1];
            dfs(t[0],-1);
        }
        this.price = price;
        int[] res = dp(0, -1);
        return Math.min(res[0], res[1]);


    }
    private boolean dfs(int x,int fa){
        if(x==end){
            cnt[x]++;
            return true;//找到end
        }
        for(int y:g[x]){
            if(y!=fa&&dfs(y,x)){
                cnt[x]++;
                return true;
            }
        }
        return false;
    }
    // 类似 337. 打家劫舍 III
    private int[] dp(int x, int fa) {
        int notHalve = price[x] * cnt[x]; // x 不变
        int halve = notHalve / 2; // x 减半
        for (int y : g[x]) {
            if (y != fa) {
                int[] res = dp(y, x); // 计算 y 不变/减半的最小价值总和
                notHalve += Math.min(res[0], res[1]); // x 不变，那么 y 可以不变，可以减半，取这两种情况的最小值
                halve += res[0]; // x 减半，那么 y 只能不变
            }
        }
        return new int[]{notHalve, halve};
    }

}

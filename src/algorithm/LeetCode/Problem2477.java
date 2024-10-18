package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem2477 {
}

class Problem2447Solution {
    private long ans;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n=roads.length+1;//节点数
        List<Integer>[] g=new ArrayList[n];
        //初始化数组，
        Arrays.setAll(g, e->new ArrayList<>());
        for(int[] e:roads){
            int x=e[0],y=e[1];
            //记录每个点的邻居
            g[x].add(y);
            g[y].add(x);
        }
        dfs(0,-1,g,seats);
        return ans;
    }

    public int dfs(int x,int fa,List<Integer>[] g,int seats){
        int size=1;
        for(int y:g[x]){
            if(y!=fa){
                //递归子节点，不能递归父节点
                //统计子树大小
                size+=dfs(y,x,g,seats);
            }
        }
        if(x>0){
            //x不是根节点
            ans+=(size-1)/seats+1;//取大整
        }
        return size;
    }
}

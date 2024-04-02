package Algorithm.CodeCapriccio.Ch9_GreedyAlgorithm;

import java.util.Arrays;

/**
 * @author jmjtc
 * <a href="https://leetcode.cn/problems/assign-cookies/description/">...</a>
 * 分发饼干
 */
public class Problem455 {
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] g, int[] s){
        int sum=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        for(int i=0;i<s.length&&count<g.length;i++){
            if(s[i]>=g[count]){
                sum++;
                count++;
            }
        }
        return sum;
    }
}

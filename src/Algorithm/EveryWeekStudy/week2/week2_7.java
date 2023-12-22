package Algorithm.EveryWeekStudy.week2;

import java.util.Arrays;

/**
 * @author jmjtc
 */
public class week2_7 {
    public static int findContentChildren(int[] g, int[] s) {
        //从小到大排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int i=0,j=0;
        //相当于两个队列，对于s每次都出队，对于g满足条件才出队
        for(;i<g.length&&j<s.length;j++){
            if(s[j]>=g[i]){
                i++;
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args){
        int[]g=new int[]{1,2};
        int[]s=new int[]{1,2,3};
        System.out.println(findContentChildren(g,s));
    }
}

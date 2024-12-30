package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-12-19
 * @Description: 3285. 找到稳定山的下标
 * @Version: 1.0
 */
public class Problem3285 {
    public static void main(String[] args) {

    }

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<height.length;i++){
            if(height[i-1]>threshold){
                ans.add(i);
            }
        }
        return ans;
    }
}

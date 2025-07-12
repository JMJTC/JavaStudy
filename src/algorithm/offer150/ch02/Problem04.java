package algorithm.offer150.ch02;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-07-12
 * @Description: 11. 盛最多水的容器
 * @Version: 1.0
 */
public class Problem04 {
    public static void main(String[] args) {

    }

    // 时间复杂度 : O(n)
    public int maxArea(int[] height) {
        int length = height.length;
        int l = 0;
        int r = length - 1;
        int ans = 0;
        while (l < r) {
            int w = r - l;
            int h = Math.min(height[l], height[r]);
            ans = Math.max(ans, w * h);
            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}

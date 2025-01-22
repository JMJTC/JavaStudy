package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-01-20
 * @Description: 2239. 找到最接近 0 的数字
 * @Version: 1.0
 */
public class Problem2239 {
    public static void main(String[] args) {

    }

    public int findClosestNumber(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            if(Math.abs(nums[i])<Math.abs(ans)||
                    (Math.abs(nums[i])==Math.abs(ans)
                            &&nums[i]>ans)){
                ans=nums[i];
            }
        }
        return ans;
    }
}

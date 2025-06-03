package algorithm.offer150.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-05-05
 * @Description: 55. 跳跃游戏
 * @Version: 1.0
 */
public class Problem09 {
    public static void main(String[] args) {

    }

    // 贪心
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int distance = nums[0];
        for (int i = 1; i <= distance && i < length; i++){
            distance = Math.max(distance, i + nums[i]);
            if (distance >= length - 1){
                return true;
            }
        }
        return distance >= length - 1;
    }
}

package algorithm.offer150.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-05-23
 * @Description: 45. 跳跃游戏 II
 * @Version: 1.0
 */
public class Problem10 {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int ans = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ) {
            ans++;
            max = i + nums[i];
            if (max >= nums.length - 1) {
                break;
            }
            int maxTemp = i;
            int maxIndex = 0;
            for (int j = i + 1; j <= max; j++) {
                if (nums[j] + j > maxTemp) {
                    maxTemp = nums[j] + j;
                    maxIndex = j;
                }
            }
            i = maxIndex;
        }
        return ans;
    }

    // O(1)
    public int jump1(int[] nums) {
        int steps=0;//记录跳跃步数
        int maxPosition=0;//记录当前能跳到的最远位置
        int end=0;
        for(int i=0;i<nums.length-1;i++){
            maxPosition=Math.max(maxPosition,i+nums[i]);//更新能跳到的最远位置
            if(i==end){//如果当前位置已经到达了能跳到的最远位置，则跳跃一步
                steps++;//跳跃一步
                end=maxPosition;
            }
        }
        return steps;
    }

}

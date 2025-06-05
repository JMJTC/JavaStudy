package algorithm.offer150.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-03
 * @Description: 135. 分发糖果
 * @Version: 1.0
 */
public class Problem15 {
    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        // 获取评分数组的长度
        int length = ratings.length;
        // 初始化答案为长度，因为每个孩子至少有一个糖果
        int ans = length;
        // 初始化上升序列的计数器
        int upCount = 1;
        // 初始化下降序列的计数器
        int downCount = 1;
        // 从数组的第二个元素开始遍历
        for (int i = 1; i < length; ) {
            // 当当前评分大于前一个评分时，上升序列计数器加1
            while (i <length && ratings[i] > ratings[i - 1]) {
                upCount++;
                i++;
            }
            // 当当前评分小于前一个评分时，下降序列计数器加1
            while (i < length && ratings[i] < ratings[i - 1]) {
                downCount++;
                i++;
            }
            // 当当前评分等于前一个评分时，跳过当前元素
            while (i < length && ratings[i] == ratings[i - 1]) {
                i++;
            }
            // 获取上升和下降序列中的最大值
            int max = Math.max(upCount, downCount);
            // 获取上升和下降序列中的最小值
            int min = Math.min(upCount, downCount);
            // 根据最大值和最小值计算糖果总数
            ans += (max - 1) * max / 2 + (min - 1) * (min - 2) / 2;
            // 重置上升和下降序列计数器
            upCount = 1;
            downCount = 1;
        }
        // 返回总的糖果数
        return ans;
    }
}

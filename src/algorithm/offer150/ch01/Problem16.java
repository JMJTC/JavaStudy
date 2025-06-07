package algorithm.offer150.ch01;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-07
 * @Description: 42. 接雨水 <a href="https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @Version: 1.0
 */
public class Problem16 {
    public static void main(String[] args) {

    }

    // 方一：前后缀分解
    public int trap1(int[] height) {
        // 获取数组长度
        int n = height.length;

        // 创建前缀最大高度数组
        int[] preMax = new int[n];
        // 初始化前缀最大高度数组的第一个元素
        preMax[0] = height[0];
        // 计算前缀最大高度数组
        for (int i = 1; i < n; i++) {
            // 当前元素的前缀最大高度为前一个元素的前缀最大高度和当前元素高度的较大值
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        // 创建后缀最大高度数组
        int[] sufMax = new int[n];
        // 初始化后缀最大高度数组的最后一个元素
        sufMax[n - 1] = height[n - 1];
        // 计算后缀最大高度数组
        for (int i = n - 2; i >= 0; i--) {
            // 当前元素的后缀最大高度为后一个元素的后缀最大高度和当前元素高度的较大值
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }

        // 初始化结果变量
        int ans = 0;
        // 计算总的雨水量
        for (int i = 0; i < n; i++) {
            // 当前柱子上方的雨水量等于前缀最大高度和后缀最大高度的较小值减去当前柱子的高度
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        // 返回总的雨水量
        return ans;
    }

    // 方二：双指针
    // 定义一个方法trap2，用于计算给定高度数组中可以存储的水量
    public int trap2(int[] height) {
        // 初始化结果变量ans为0，用于存储最终计算的水量
        int ans = 0;
        // 初始化左指针left为0，指向数组的起始位置
        int left = 0;
        // 初始化右指针right为数组长度减1，指向数组的末尾位置
        int right = height.length - 1;
        // 初始化前缀最大值preMax为0，用于存储从左到当前元素的最大高度
        int preMax = 0;
        // 初始化后缀最大值sufMax为0，用于存储从右到当前元素的最大高度
        int sufMax = 0;

        // 使用while循环，当左指针小于右指针时继续循环
        while (left < right) {
            // 更新前缀最大值preMax为当前left位置的高度和preMax的较大值
            preMax = Math.max(preMax, height[left]);
            // 更新后缀最大值sufMax为当前right位置的高度和sufMax的较大值
            sufMax = Math.max(sufMax, height[right]);

            // 根据前缀最大值和后缀最大值的大小关系，决定从哪一侧计算水量
            // 如果前缀最大值小于后缀最大值，则从左侧计算水量
            if (preMax < sufMax) {
                // 计算当前left位置的水量，并累加到结果变量ans中
                ans += preMax - height[left++];
            } else {
                // 否则，从右侧计算水量，并累加到结果变量ans中
                ans += sufMax - height[right--];
            }
        }

        // 返回最终计算的水量结果
        return ans;
    }

    // 方三：单调栈
    public int trap(int[] height) {
        // 初始化结果变量，用于存储总的积水量
        int ans = 0;
        // 使用双端队列来存储柱子的索引
        Deque<Integer> st = new ArrayDeque<>();
        // 遍历每一根柱子
        for (int i = 0; i < height.length; i++) {
            // 当当前柱子的高度大于等于栈顶柱子的高度时，进行计算
            while (!st.isEmpty() && height[i] >= height[st.peek()]) {
                // 弹出栈顶元素，获取底部柱子的高度
                int bottomH = height[st.pop()];
                // 如果栈为空，说明没有左边界，跳出循环
                if (st.isEmpty()) {
                    break;
                }
                // 获取左边界柱子的索引
                int left = st.peek();
                // 计算当前柱子和左边界柱子之间的高度差
                int dh = Math.min(height[left], height[i]) - bottomH;
                // 计算当前这一层的积水量，并累加到总积水量中
                ans += dh * (i - left - 1);
            }
            // 将当前柱子的索引压入栈中
            st.push(i);
        }
        // 返回总的积水量
        return ans;
    }
}

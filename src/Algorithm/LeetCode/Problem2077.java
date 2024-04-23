package Algorithm.LeetCode;

import java.util.*;

/**
 * @author jmjtc
 */
public class Problem2077 {

    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // 如果changed数组长度为奇数，直接返回空数组
        }

        // 创建一个HashMap来记录每个元素出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : changed) { 
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> originalList = new ArrayList<>();
        Arrays.sort(changed); // 对changed数组进行排序
        for (int num : changed) {
            if (countMap.getOrDefault(num, 0) > 0) {
                if (countMap.getOrDefault(num * 2, 0) > 0) {
                    originalList.add(num); // 若num和num*2都存在，则将num加入原始数组，并更新HashMap中的元素计数
                    countMap.put(num, countMap.get(num) - 1);
                    countMap.put(num * 2, countMap.get(num * 2) - 1);
                }
            }
        }

        for (int count : countMap.values()) {
            if (count > 0) {
                return new int[0]; // 如果HashMap中还有剩余元素，则返回空数组
            }
        }

        int[] original = new int[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            original[i] = originalList.get(i); // 将List转换为数组
        }

        return original; // 返回原始数组
    }

    public static void main(String[] args) {
        int[] result1 = findOriginalArray(new int[]{1, 3, 4, 2, 6, 8});
        System.out.println(Arrays.toString(result1));  // 输出：[1, 3, 4]

        int[] result2 = findOriginalArray(new int[]{6, 3, 0, 1});
        System.out.println(Arrays.toString(result2));  // 输出：[]

        int[] result3 = findOriginalArray(new int[]{1});
        System.out.println(Arrays.toString(result3));  // 输出：[]
    }
}

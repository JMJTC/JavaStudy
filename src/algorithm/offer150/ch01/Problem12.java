package algorithm.offer150.ch01;

import java.util.*;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-03
 * @Description:380. O(1) 时间插入、删除和获取随机元素
 * @Version: 1.0
 */
public class Problem12 {
    public static void main(String[] args) {

    }

}

class RandomizedSet {
    private Set<Integer> set = new HashSet<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        }
        set.remove(val);
        return true;
    }

    public int getRandom() {
        int index = (int) (Math.random() * set.size());
        int i = 0;
        for (Integer integer : set) {
            if (i == index) {
                return integer;
            }
            i++;
        }
        return -1;
    }

}

// 严格O(1) map key：val值， value：索引
class RandomizedSet1 {
    // 定义一个静态数组，用于存储插入的元素
    static int[] nums = new int[200010];
    // 定义一个随机数生成器，用于生成随机索引
    Random random = new Random();
    // 定义一个哈希表，用于存储元素及其在数组中的索引
    Map<Integer, Integer> map = new HashMap<>();
    // 定义一个索引变量，用于记录当前插入的位置
    int idx = -1;

    // 插入元素的方法
    public boolean insert(int val) {
        // 如果哈希表中已经包含该元素，则插入失败
        if (map.containsKey(val)) {
            return false;
        }
        // 将元素插入到数组的下一个位置
        nums[++idx] = val;
        // 将元素及其索引存入哈希表
        map.put(val, idx);
        // 插入成功，返回true
        return true;
    }

    // 删除元素的方法
    public boolean remove(int val) {
        // 如果哈希表中不包含该元素，则删除失败
        if (!map.containsKey(val)) {
            return false;
        }
        // 从哈希表中获取该元素的索引
        int loc = map.remove(val);
        // 如果该元素不是数组中的最后一个元素
        if (loc != idx) {
            // 将数组中的最后一个元素移动到该位置
            map.put(nums[idx], loc);
        }
        // 将数组中的最后一个元素移动到该位置
        nums[loc] = nums[idx--];
        // 删除成功，返回true
        return true;
    }

    // 获取随机元素的方法
    public int getRandom() {
        // 生成一个随机索引，并返回对应的元素
        return nums[random.nextInt(idx + 1)];
    }
}



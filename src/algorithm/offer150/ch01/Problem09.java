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
class RandomizedSet1 {
    // 定义一个静态数组，用于存储插入的元素
    static int[] nums = new int[200010];
    // 定义一个随机数生成器，用于生成随机索引
    Random random = new Random();
    // 定义一个哈希表，用于存储元素及其在数组中的索引
    Map<Integer, Integer> map = new HashMap<>();
    // 定义一个索引变量，用于记录当前数组中元素的个数
    int idx = -1;

    // 插入元素的方法
    public boolean insert(int val) {
        // 如果哈希表中已经包含该元素，则插入失败
        if (map.containsKey(val)) {
            return false;
        }
        // 将元素插入到数组的末尾，并更新哈希表
        nums[++idx] = val;
        map.put(val, idx);
        return true;
    }

    // 删除元素的方法
    public boolean remove(int val) {
        // 如果哈希表中不包含该元素，则删除失败
        if (!map.containsKey(val)) {
            return false;
        }
        // 获取该元素在数组中的索引
        int loc = map.remove(val);
        // 如果该元素不是数组中的最后一个元素，则将其与最后一个元素交换
        if (loc != idx) {
            map.put(nums[idx], loc);
        }
        // 将最后一个元素移动到被删除元素的位置，并更新索引
        nums[loc] = nums[idx--];
        return true;
    }

    // 获取随机元素的方法
    public int getRandom() {
        // 生成一个随机索引，并返回对应的元素
        return nums[random.nextInt(idx + 1)];
    }
}

}

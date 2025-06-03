package algorithm.offer150.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-03
 * @Description: 134. 加油站
 * @Version: 1.0
 */
public class Problem14 {
    public static void main(String[] args) {

    }

    /**
     * 判断能否完成环形路线
     *
     * @param gas  每个加油站的汽油量
     * @param cost 每个加油站到下一个加油站所需的汽油量
     * @return 如果可以完成环形路线，返回起始加油站的索引；否则返回-1
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length; // 获取加油站的数量
        int sum = 0; // 用于记录总的汽油量减去总的成本的差值
        int min = 0; // 用于记录当前遍历过程中汽油量减去成本的最小差值
        int ans = 0; // 用于记录可能的起始加油站索引

        // 遍历所有加油站
        for (int i = 0; i < length; i++) {
            sum += gas[i] - cost[i]; // 累加当前加油站的汽油量减去成本的差值
            // 如果当前累加的差值小于之前记录的最小差值
            if (sum < min) {
                min = sum; // 更新最小差值
                ans = i + 1; // 更新可能的起始加油站索引为当前索引加1
            }
        }

        // 如果总的汽油量减去总的成本小于0，说明无法完成环形路线
        if (sum < 0) {
            return -1; // 返回-1表示无法完成环形路线
        }

        // 返回可能的起始加油站索引，取模是为了处理环形结构
        return ans % length;
    }
}

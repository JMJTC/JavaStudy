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

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int sum = 0;
        int min = 0;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                ans = i + 1;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return ans % length;
    }
}

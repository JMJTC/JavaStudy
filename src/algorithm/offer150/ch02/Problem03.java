package algorithm.offer150.ch02;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-07-10
 * @Description: 167. 两数之和 II - 输入有序数组
 * @Version: 1.0
 */
public class Problem03 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (numbers[index1] + numbers[index2] != target) {
            if (numbers[index1] + numbers[index2] > target) {
                index2--;
            } else {
                index1++;
            }
        }
        return new int[]{index1, index2};
    }
}

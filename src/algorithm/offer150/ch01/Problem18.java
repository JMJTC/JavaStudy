package algorithm.offer150.ch01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-07
 * @Description: 12. 整数转罗马数字 <a href="https://leetcode.cn/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 * @Version: 1.0
 */
public class Problem18 {
    public static void main(String[] args) {
        Problem18 p = new Problem18();
        System.out.println(p.intToRoman(1994));
    }

    public String intToRoman(int num) {
        // 创建一个Map来存储罗马数字和对应的整数值
        Map<Integer, String> map = new HashMap<>();
        // 初始化Map
        initMap(map);
        // 创建一个StringBuilder来构建最终的罗马数字字符串
        StringBuilder ans = new StringBuilder();
        // 计数器，用于记录当前处理的位数
        int count = 0;
        // 临时变量，用于处理输入的整数
        int temp = num;
        // 创建一个数组来存储每一位的数字
        int[] data = new int[]{-1, -1, -1, -1};
        // 将输入的整数按位拆分存储到数组中
        while (temp > 0) {
            data[count] = temp % 10;
            temp /= 10;
            count++;
        }
        // 从高位到低位处理每一位数字
        for (int i = count; i > 0; i--) {
            // 如果当前位的数字可以直接映射到罗马数字，则直接添加
            if (map.containsKey(data[i - 1] * (int) Math.pow(10, i - 1))) {
                ans.append(map.get(data[i - 1] * (int) Math.pow(10, i - 1)));
            } else {
                // 计算当前位的数字中5的倍数部分
                int cur1 = data[i - 1] / 5;
                // 计算当前位的数字中剩余的部分
                int cur2 = data[i - 1] % 5;
                // 如果5的倍数部分大于0，则添加对应的罗马数字
                if (cur1 > 0) {
                    ans.append(map.get((int) Math.pow(10, i - 1) * 5));
                }
                // 添加剩余部分的罗马数字
                for (int j = 0; j < cur2; j++) {
                    ans.append(map.get((int) Math.pow(10, i - 1)));
                }
            }
        }
        // 返回最终的罗马数字字符串
        return ans.toString();
    }

    // 初始化Map，将罗马数字和对应的整数值放入Map中
    private void initMap(Map<Integer, String> map) {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    // 优化后的代码
    // 把 num 拆分成千位数、百位数、十位数和个位数，分别用罗马数字表示
    private static final String[][] R = new String[][]{
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, // 个位
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, // 十位
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // 百位
            {"", "M", "MM", "MMM"}, // 千位
    };

    public String intToRoman1(int num) {
        return R[3][num / 1000] + R[2][num / 100 % 10] + R[1][num / 10 % 10] + R[0][num % 10];
    }
}

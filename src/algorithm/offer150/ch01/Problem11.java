package algorithm.offer150.ch01;

import java.util.Arrays;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-05-23
 * @Description:
 * @Version: 1.0
 */
public class Problem11 {
    public static void main(String[] args) {

    }

    // 模拟 时间复杂度 O(n^2)
    public int hIndex(int[] citations) {
        int length = citations.length;
        int[] data = new int[length + 1];
        int ans = 0;
        for (int i : citations) {
            for (int index = ans; index <= i && index <= length; index++) {
                data[index]++;
                if (data[index] >= index) {
                    ans = index;
                }
            }
        }
        return ans;
    }

    // 排序 时间复杂度 O(nlogn)
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    // 计数 时间复杂度 O(n)
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for (int c : citations) {
            cnt[Math.min(c, n)]++; // 引用次数 > n，等价于引用次数为 n
        }
        int s = 0;
        for (int i = n; ; i--) { // i=0 的时候，s>=i 一定成立
            s += cnt[i];
            if (s >= i) { // 说明有至少 i 篇论文的引用次数至少为 i
                return i;
            }
        }
    }
}

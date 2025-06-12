package algorithm.contestlan.guo15th;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-12
 * @Description:
 * @Version: 1.0
 */
public class D {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int[] arr = new int[n + 1];
        s = br.readLine();
        String[] str = s.split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = getSquareFree(Integer.parseInt(str[i - 1]));
        }

        Map<Integer, List<Integer>> hash = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            s = br.readLine();
            int key = Integer.parseInt(s.split(" ")[0]);
            int value = Integer.parseInt(s.split(" ")[1]);
            if (!hash.containsKey(key)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(value);
                hash.put(key, temp);
            } else {
                hash.get(key).add(value);
            }
        }

        int ans = 0;
        // 遍历hash, 找到子节点数大于二的节点并判断是否需要处理
        for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()) {
            List<Integer> temp = entry.getValue();
            if (temp.size() >= 2) {
                ans += changeNumberCount(temp, arr);
            }
        }
        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }

    // 计算平方自由数：只保留质因子的奇数次幂
    private static int getSquareFree(int x) {
        int res = 1;
        for (int i = 2; i * i <= x; i++) {
            int count = 0;
            while (x % i == 0) {
                count++;
                x /= i;
            }
            if ((count & 1) == 1) {
                res *= i;
            }
        }
        if (x > 1) {
            res *= x;
        }
        return res;
    }

    private static int changeNumberCount(List<Integer> list, int[] data) {
        int res = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i : list) {
            hash.put(data[i], hash.getOrDefault(data[i], 0) + 1);
        }

        for (int i : hash.values()) {
            if (i > 1) {
                res += i - 1;
            }
        }
        return res;
    }
}

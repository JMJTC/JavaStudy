package algorithm.contestlan.guo15th;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-12
 * @Description:
 * @Version: 1.0
 */
public class C {
    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int k = Integer.parseInt(s);
        s = br.readLine();
        int n = Integer.parseInt(s);
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            data[i] = Integer.parseInt(s);
        }
        List<Integer> record = new ArrayList<>();
        for (int i = 1; i < 1000001; ) {
            int left = i;
            int right = i + k;
            while (gcd(left, right) != 1) {
                right++;
            }
            record.add(right);
            i = right + 1;
        }
        // 二分
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = record.size() - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (record.get(mid) > data[i]) {
                    right = mid - 1;
                } else if (record.get(mid) < data[i]) {
                    left = mid + 1;
                } else {
                    left = mid;
                    break;
                }
            }
            bw.write(left + 1 + "");
            if (i != n - 1) {
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

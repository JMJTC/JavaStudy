package algorithm.contestlan.province14th;

import java.io.*;
import java.util.*;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-02
 * @Description: 玩具
 * @Version: 1.0
 */


public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int[] weight = new int[2 * n];
        s = br.readLine().split(" ");
        for (int i = 0; i < weight.length; i++) {
            weight[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(weight);
        //数学，最小的和最大的匹配
        long ans = 0;
        for (int i = 0; i < weight.length / 2; i++) {
            ans += ((long) weight[i] * weight[weight.length - 1 - i]);
        }
        bw.write(ans + "");
        bw.flush();

        bw.close();
        br.close();
    }
}

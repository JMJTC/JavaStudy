package algorithm.contestlan.province12th;

import java.util.Scanner;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-02
 * @Description: 卡片
 * @Version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 1;
        long count = 2;
        while (n > count) {
            k++;
            count *= 2;
        }
        System.out.print(k);
    }
}

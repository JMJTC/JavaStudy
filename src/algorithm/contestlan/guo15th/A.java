package algorithm.contestlan.guo15th;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-06-12
 * @Description:
 * @Version: 1.0
 */
public class A {
    public static void main(String[] args) {
        long ans = 0;
        for (int i = 0; i < 20240601; i++) {
            ans = ans + 5 * i +1;
        }
        System.out.println(ans);
        System.out.println(Long.MAX_VALUE);
    }
}

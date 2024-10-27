package algorithm.everyweekstudy.week4;



/**
 * @author jmjtc
 */
public class week4_9 {
    public static int preimageSizeFZF(int k) {
        if (k <= 1) {
            return 5;
        }
        return f(k) - f(k - 1);
    }
    public static int f(int x) {
        long l = 0, r = (long) 1e10;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (getCnt(mid) <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int)r;
    }
    public static long getCnt(long x) {
        long ans = 0;
        while (x != 0) {
            ans += x / 5; x /= 5;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(preimageSizeFZF(0));
    }
}

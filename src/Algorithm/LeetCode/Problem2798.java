package Algorithm.LeetCode;

/**
 * @author jmjtc
 */
public class Problem2798 {
    public static void main(String[] args) {

    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans=0;
        for (int hour : hours) {
            if (hour >= target) {
                ans++;
            }
        }
        return ans;
    }
}

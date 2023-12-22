package Algorithm.EveryWeekStudy.week4;

public class _11_12 {
}


class _11_12_1_Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int index=0;
        int[] ans=new int[n];
        for (int num : nums) {
            if (num != 0) {
                ans[index++] = num;
            }
        }
        System.arraycopy(ans, 0, nums, 0, n);
    }
}

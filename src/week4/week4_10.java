package week4;

public class week4_10 {
    public int countTriplets(int[] nums) {
        int max=1<<16;
        int[] cnt=new int[max];
        int ans=0,n=nums.length;
        //先统计i,j
        for (int num : nums) {
            for (int i : nums) {
                cnt[num & i]++;
            }
        }
        for (int num : nums) {
            for (int ij = 0; ij < max; ij++) {
                if ((ij & num) == 0) {
                    ans += cnt[ij];
                }
            }
        }
        return ans;
    }

    public int countTripletsTwo(int[] nums) {
        int u = 1;
        for (int x : nums)
            while (u <= x)
                u <<= 1;
        int[] cnt = new int[u];
        cnt[0] = nums.length; // 直接统计空集
        for (int m : nums) {
            m ^= u - 1;
            for (int s = m; s > 0; s = (s - 1) & m) // 枚举 m 的非空子集
                ++cnt[s];
        }
        int ans = 0;
        for (int x : nums)
            for (int y : nums)
                ans += cnt[x & y];
        return ans;
    }
}

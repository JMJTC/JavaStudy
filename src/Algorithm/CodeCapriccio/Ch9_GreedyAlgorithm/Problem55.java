package Algorithm.CodeCapriccio.Ch9_GreedyAlgorithm;

/**
 * @author jmjtc
 */
public class Problem55 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        boolean[] flag=new boolean[nums.length];
        flag[0]=true;
        for(int i=0;i<nums.length;i++) {
            if(flag[nums.length-1]){
                break;
            }
            if(flag[i]){
                for(int j=1;j<=nums[i]&&i+j<nums.length;j++) {
                    flag[i + j] = true;
                }
            }
        }

        return flag[nums.length-1];
    }

    // 贪心算法
    // 贪心策略：从右往左遍历数组，如果当前位置能跳到右边界，则跳到右边界。
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean canJump1(int[] nums){
        int rightmost=0;
        for(int i=0;i<nums.length;i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= nums.length - 1) {
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
}

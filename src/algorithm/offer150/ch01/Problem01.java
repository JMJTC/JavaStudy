package algorithm.offer150.ch01;

/**
 * @author jmjtc
 * <a href="https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150">...</a>
 */
public class Problem01 {
    public static void main(String[] args) {
        Problem01 problem01 = new Problem01();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        problem01.merge(nums1, 3, nums2, 3);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        int end = m;
        while (index1 < m + n && index2 < n) {
            if (nums1[index1] > nums2[index2]) {
                //插入&&后移
                for (int i = end; i > index1; i--) {
                    nums1[i] = nums1[i - 1];
                }
                nums1[index1] = nums2[index2];
                index2++;
                end++;
            }
            index1++;
        }
        if (index2 < n) {
            for (int i = end; i < m + n; i++) {
                nums1[i] = nums2[index2++];
            }
        }
    }
}

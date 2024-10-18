package algorithm.LeetCode;

public class Problem3101 {
    public static void main(String[] args) {
        new Problem3101().countAlternatingSubarrays1(new int[]{1, 0, 1, 0});
    }

    //暴力超时
    public long countAlternatingSubarrays(int[] nums) {
        // Initialize the answer to 0
        int ans = 0;
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Increment the answer by 1
            ans++;
            // Iterate through the rest of the array
            for (int j = i + 1; j < nums.length; j++) {
                // If the current element is not equal to the previous element
                if (nums[j] != nums[j - 1]) {
                    // Increment the answer by 1
                    ans++;
                } else {
                    // Otherwise, break the loop
                    break;
                }
            }
        }
        // Return the answer
        return ans;
    }

    public long countAlternatingSubarrays1(int[] nums) {
        // Initialize the answer to 0
        long ans = 0;
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Increment the answer
            ans++;
            // Initialize the count to 1
            int count = 1;
            // Iterate through the rest of the array
            for (int j = i + 1; j < nums.length; j++) {
                // If the current element is not equal to the previous element
                if (nums[j] != nums[j - 1]) {
                    // Increment the count
                    count++;
                    // Add the count to the answer
                    ans += count;
                } else {
                    // If the current element is equal to the previous element, set i to j-1 and break the loop
                    i = j - 1;
                    break;
                }
                // If the current element is the last element in the array, set i to j and break the loop
                if (j == nums.length - 1) {
                    i = j;
                }
            }
        }
        // Return the answer
        return ans;
    }
}

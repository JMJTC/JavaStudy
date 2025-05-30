package algorithm.leetcode;

/**
 * @author jmjtc
 */
public class Problem2697 {
}

class Problem2697Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr=s.toCharArray();
        int left=0,right=arr.length-1;
        while(left<right){
            if(arr[left]!=arr[right]){
                arr[left]=arr[right]=(char)Math.min(arr[left],arr[right]);
            }
            ++left;
            --right;
        }
        return new String(arr);
    }
}

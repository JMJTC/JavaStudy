package algorithm.LeetCode;

/**
 * @author jmjtc
 */
public class Problem1186 {
    public static void main(String[] args) {

    }
    public int maximumSum(int[] arr) {
        int ans=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            if(min>i){
                min=i;
            }
            if(max<i){
                max=i;
            }
            if(i>0){
                ans+=i;
            }
        }
        if(max<=0){
            return max;
        }
        if(min>=0){
            return ans;
        }
        return ans;
    }
}

package algorithm.code_capriccio.Ch13_MonotoneStack;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-17
 * @Description: 下一个更大元素
 * @Version: 1.0
 */
public class Problem496 {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=-1;
        }
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    for(int k=j+1;k<nums2.length;k++){
                        if(nums2[k]>nums2[j]){
                            ans[i]=nums2[k];
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}

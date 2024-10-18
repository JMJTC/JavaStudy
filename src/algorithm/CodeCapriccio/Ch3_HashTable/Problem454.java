package algorithm.CodeCapriccio.Ch3_HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jmjtc
 */
public class Problem454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        int ans=0;
        Map<Integer,Integer> record=new HashMap<>();
        for(int i:nums1){
            for(int j:nums2){
                int temp=i+j;
                record.put(temp, record.getOrDefault(temp,0)+1);
            }
        }
        for(int i:nums3){
            for(int j:nums4){
                ans+=record.getOrDefault(-i - j,0);
            }
        }
        return ans;
    }
}

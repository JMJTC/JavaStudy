package algorithm.code_capriccio.ch3.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jmjtc
 */
public class Problem349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        for (int j : nums1) {
            visited.add(j);
        }
        for (int j : nums2) {
            if (visited.contains(j)&& !res.contains(j)) {
                res.add(j);
            }
        }
        int[] ans=new int[res.size()];
        int i=0;
        for(int list:res){
            ans[i++]=list;
        }
        return ans;
    }
}

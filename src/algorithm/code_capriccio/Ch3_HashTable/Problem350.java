package algorithm.code_capriccio.Ch3_HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem350 {
    public static void main(String[] args) {
        int[] nums1=new int[]{1,1,2,5};
        int[] nums2=new int[]{3,4,5,5};
        new Problem350().intersect(nums1,nums2);
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] visited1=new int[1001];
        int[] visited2=new int[1001];
        record(nums1,visited1);
        record(nums2,visited2);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<1001;i++){
            if(visited2[i]!=0&&visited1[i]!=0){
                for(int j=0;j<Math.min(visited1[i],visited2[i]);j++){
                    ans.add(i);
                }
            }
        }
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]= ans.get(i);
        }
        return res;
    }
    public void record(int[] num,int[] visited){
        for(int m:num){
            visited[m]++;
        }
    }
}

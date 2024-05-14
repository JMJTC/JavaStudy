package Algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jmjtc
 */
public class Problem2244 {
    public static void main(String[] args) {

    }

    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:tasks){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int ans=0;
        for(int i:map.values()){
            if(i==1){
                ans=-1;
                break;
            }
            ans+=(i/3);
            int temp=(i%3);
            if(temp==2){
                ans++;
            }else if(temp==1){
                ans+=1;
            }
        }
        return ans;
    }
}

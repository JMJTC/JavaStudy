package algorithm.CodeCapriccio.Ch1_Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jmjtc
 */
public class Problem904 {
    public static void main(String[] args) {

    }
}

class Problem904_Solution1{
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        Map<Integer,Integer> cnt=new HashMap<>();
        int left=0,ans=0;
        for(int right=0;right<n;right++){
            cnt.put(fruits[right],cnt.getOrDefault(fruits[right],0)+1);
            while(cnt.size()>2){
                cnt.put(fruits[left],cnt.get(fruits[left])-1);
                if(cnt.get(fruits[left])==0){
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}

class Problem904_Solution2{
    public int totalFruit(int[] fs) {
        int n = fs.length, ans = 0;
        int[] cnts = new int[n + 10];
        for (int i = 0, j = 0, tot = 0; i < n; i++) {
            if (++cnts[fs[i]] == 1) {
                tot++;
            }
            while (tot > 2) {
                if (--cnts[fs[j++]] == 0) {
                    tot--;
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}

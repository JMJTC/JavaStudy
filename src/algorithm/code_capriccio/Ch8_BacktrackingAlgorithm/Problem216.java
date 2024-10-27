package algorithm.code_capriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem216 {
    public List<List<Integer>> ans=new ArrayList<>();
    public List<Integer> path=new ArrayList<>();
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n>45||n==1){
            return ans;
        }
        backTracking(n,k,1);
        return ans;
    }

    public void backTracking(int sum,int count,int start){
        if(sum==0&&path.size()==count){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(sum<0||path.size()==count){
            return;
        }
        for(int i=start;i<=9;i++){
            path.add(i);
            backTracking(sum-i,count,i+1);
            //回溯
            path.remove(path.size()-1);
        }
    }
}

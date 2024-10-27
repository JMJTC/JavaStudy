package algorithm.code_capriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem77 {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public static void main(String[] args) {
        new Problem77().combine(4,2);
    }

    public void backTracking(int n,int k,int startIndex){
        if(path.size()==k){
            ans.add(new ArrayList<>(path));//注意这里不能是引用的传递，需要新建一个对象！！！
            return;
        }
        for(int i=startIndex;i<=n;i++){
            path.add(i);
            backTracking(n,k,i+1);
            //回溯
            path.remove(path.size()-1);
        }
    }

    //剪枝
    public void backTracking1(int n,int k,int startIndex){
        if(path.size()==k){
            ans.add(new ArrayList<>(path));//注意这里不能是引用的传递，需要新建一个对象！！！
            return;
        }
        for(int i=startIndex;i<=n-(k-path.size())+1;i++){
            path.add(i);
            backTracking1(n,k,i+1);
            //回溯
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k){
        backTracking(n,k,1);
        return ans;
    }
}

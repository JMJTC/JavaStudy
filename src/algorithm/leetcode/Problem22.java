package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-24
 * @Description: 22. 括号生成
 * @Version: 1.0
 */
public class Problem22 {
    private List<String> ans=new ArrayList<>();
    private StringBuilder temp=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        int left=0;
        int right=0;
        backTranking(0,0,n);
        return ans;
    }

    public void backTranking(int left,int right,int n){
        if(left==n&&right==n){
            ans.add(temp.toString());
            return;
        }
        if(left>n||right>n||right>left){
            return;
        }
        temp.append('(');
        backTranking(left+1,right,n);
        temp.deleteCharAt(temp.length()-1);
        temp.append(')');
        backTranking(left,right+1,n);
        temp.deleteCharAt(temp.length()-1);
    }
}

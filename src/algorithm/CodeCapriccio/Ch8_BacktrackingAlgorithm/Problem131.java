package algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem131 {
    private StringBuilder str=new StringBuilder();
    private List<List<String>> ans=new ArrayList<>();
    private List<String> path=new ArrayList<>();
    public static void main(String[] args) {
        new Problem131().partition("aab");
    }

    public List<List<String>> partition(String s){
        backTracking(s,0);
        return ans;
    }

    public void backTracking(String s,int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = index; i < s.length(); i++) {
            str.delete(0, str.length());
            boolean flag = false;
            for (int j = index; j <= i; j++) {
                str.append(s.charAt(j));
            }
            if (isPalindrome(str.toString())) {
                path.add(str.toString());
                flag = true;
            } else {
                break;
            }
            backTracking(s, i + 1);
            if (flag) {
                path.remove(path.size() - 1);
            }
        }
    }

    //判断回文
    public boolean isPalindrome(String s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

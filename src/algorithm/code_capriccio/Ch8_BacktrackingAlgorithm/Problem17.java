package algorithm.code_capriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jmjtc
 */
public class Problem17 {
    public Map<Integer,List<Character>> hash=new HashMap<>();
    public List<String> ans=new ArrayList<>();
    public StringBuilder path=new StringBuilder();
    public static void main(String[] args) {
        String digits="23";
        new Problem17().letterCombinations(digits);
    }

    public List<String> letterCombinations(String digits) {
        //初始化 hash
        for(int i=2;i<=9;i++){
            switch (i){
                case 2:
                    hash.put(2,List.of('a','b','c'));
                    break;
                case 3:
                    hash.put(3,List.of('d','e','f'));
                    break;
                case 4:
                    hash.put(4,List.of('g','h','i'));
                    break;
                case 5:
                    hash.put(5,List.of('j','k','l'));
                    break;
                case 6:
                    hash.put(6,List.of('m','n','o'));
                    break;
                case 7:
                    hash.put(7,List.of('p','q','r','s'));
                    break;
                case 8:
                    hash.put(8,List.of('t','u','v'));
                    break;
                case 9:
                    hash.put(9,List.of('w','x','y','z'));
                    break;
            }
        }
        if(digits.isEmpty()){
            return ans;
        }
        backTracking(digits,0);
        return ans;
    }

    public void backTracking(String digits,int index){
        //终止条件
        if(path.length()==digits.length()){
            ans.add(new String(path));
            return;
        }

        for(int i=index;i<digits.length();i++){
            char c=digits.charAt(i);
            if(hash.containsKey(c-'0')){
                for(char ch:hash.get(c-'0')){
                    path.append(ch);
                    backTracking(digits,i+1);
                    //回溯
                    path.deleteCharAt(path.length()-1);
                }
            }
        }
    }
}

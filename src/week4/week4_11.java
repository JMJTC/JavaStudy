package week4;

import java.util.*;

/**
 * @author jmjtc
 */
public class week4_11 {
    public static void main(String[] args){
        String[] words=new String[]{"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles=new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        new week4_11_solution().findNumOfValidWords(words,puzzles);
    }
}

class week4_11_solution{
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ans=new ArrayList<>();
        int n1=puzzles.length;
        int n2=words.length;
        //对words进行预处理，去重
        Map<Integer,Map<Character,Integer>> map=new HashMap<>();
        for(int i=0;i<n2;i++){
            Map<Character,Integer> temp=new HashMap<>();
            int length=words[i].length();
            for(int j=0;j<length;j++){
                temp.put(words[i].charAt(j),1);
            }
            map.put(i,temp);
        }
        int[] data=new int[n1];
        for(int i=0;i<n2;i++){
            for(int j=0;j<n1;j++){
                if(isTrue(map.get(j),puzzles[i])){
                    data[j]++;
                }
            }
        }

//        for(int i=0;i<n1;i++){
//            int cnt=0;
//            for(int j=0;j<n2;j++){
//                if(isTrue(map.get(j),puzzles[i])){
//                    cnt++;
//                }
//            }
//            ans.add(cnt);
//        }
        return ans;
    }

    public boolean isTrue(Map<Character,Integer>word,String puzzle){
        //Map<Character,Integer> map=new HashMap<>();
        //int n1=word.length();
        int n2=puzzle.length();
        //for(int i=0;i<n1;i++){
        //    map.put(word.charAt(i),1);
        //}
        if(!word.containsKey(puzzle.charAt(0))){
            return false;
        }
        for(int i=0;i<n2;i++){
            word.put(puzzle.charAt(i),0);
        }
        return !word.containsValue(1);
    }
}



class week4_11Solution {
    public List<Integer> findNumOfValidWords(String[] ws, String[] ps) {
        // 转用 「哈希表」来统计出所有的 word 所对应的二进制数值
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : ws) {
            int t = getBin(w);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        // 判定每个 puzzle 有多少个谜底
        List<Integer> ans = new ArrayList<>();
        for (String p : ps) ans.add(getCnt(map, p));
        return ans;
    }
    int getCnt(Map<Integer, Integer> map, String str) {
        int ans = 0;
        int m = str.length();
        char[] cs = str.toCharArray();
        // 当前 puzzle 的首个字符在二进制数值中的位置
        int first = cs[0] - 'a';
        // 枚举「保留首个字母」的所有子集
        // 即我们需要先固定 puzzle 的首位字母，然后枚举剩余的 6 位是否保留
        // 由于是二进制，每一位共有 0 和 1 两种选择，因此共有 2^6 种可能性，也就是 2^6 = 1 << (7 - 1) = 64 种
        // i 代表了所有「保留首个字母」的子集的「后六位」的二进制表示
        for (int i = 0; i < (1 << (m - 1)); i++) {
            // u 代表了当前可能的谜底。先将首字母提取出来
            int u = 1 << first;
            // 枚举「首个字母」之后的每一位
            for (int j = 1; j < m; j++) {
                // 如果当前位为 1，代表该位置要保留，将该位置的字母追加到谜底 u 中
                if (((i >> (j - 1)) & 1) != 0) u += 1 << (cs[j] - 'a');
            }
            // 查询这样的字符是否出现在 `words` 中，出现了多少次
            if (map.containsKey(u)) ans += map.get(u);
        }
        return ans;
    }
    // 将 str 所包含的字母用二进制标识
    // 如果 str = abz 则对应的二进制为 100...011 (共 26 位，从右往左是 a - z)
    int getBin(String str) {
        int t = 0;
        char[] cs = str.toCharArray();
        for (char c : cs) {
            // 每一位字符所对应二进制数字中哪一位
            int u = c - 'a';
            // 如果当前位置为 0，代表还没记录过，则进行记录 (不重复记录)
            if ((t >> u & 1) == 0) t += 1 << u;
        }
        return t;
    }
}

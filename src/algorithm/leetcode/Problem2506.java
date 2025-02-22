package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-22
 * @Description: 2506. 统计相似字符串对的数目
 * @Version: 1.0
 */
public class Problem2506 {
    public static void main(String[] args) {
        String[] words=new String[]{"aba","aabb","abcd","bac","aabc"};
        new Problem2506().similarPairs(words);
    }

    public int similarPairs(String[] words) {
        int length=words.length;
        int[][] data=new int[length][26];
        for(int i=0;i<length;i++){
            int l=words[i].length();
            for(int j=0;j<l;j++){
                data[i][words[i].charAt(j)-'a']++;
            }
        }
        int ans=0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                boolean flag=true;
                for(int k=0;k<26;k++){
                    if(data[i][k]==0&&data[j][k]==0){
                        continue;
                    }
                    if(data[i][k]*data[j][k]==0){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     *字符串仅由小写字母组成，因此一个字符串含有的字符集合，
     * 可以用一个26位的二进制数字表示状态。从低位到高位，如果这一位为1，
     * 则表示含有对应的小写字母。遍历words，并用一个哈希表cnt记录每个状态出现的次数，
     * 对于每个word，计算其对应的状态state，并将结果增加cnt[state]，
     * 表示当前字符串与之前遍历过的所有同状态的字符串都相似，然后将cnt[state]自增1。最后返回结果。
     * 时间复杂度：O(m×n)，其中n是数组words的长度，m是数组words中单个字符串的平均长度。
     * 空间复杂度：O(n)。
     */
    public int similarPairs1(String[] words) {
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (String word : words) {
            int state = 0;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                state |= 1 << (c - 'a');//按位或赋值
            }
            res += cnt.getOrDefault(state, 0);
            cnt.put(state, cnt.getOrDefault(state, 0) + 1);
        }
        return res;
    }
}

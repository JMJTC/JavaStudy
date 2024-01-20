package Algorithm.CodeCapriccio.Ch3_HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jmjtc
 */
public class Problem383 {

    public boolean canConstruct(String ransomNote, String magazine){
        Map<Character,Integer> record=new HashMap<>();
        for(char c:magazine.toCharArray()){
            record.put(c,record.getOrDefault(c,0)+1);
        }
        for(char c:ransomNote.toCharArray()){
            record.put(c,record.getOrDefault(c,0)-1);
            if(record.get(c)<0){
                return false;
            }
        }
        return true;
    }


    //本题只有小写字母，用数组节省空间复杂度
    public boolean canConstruct1(String ransomNote, String magazine){
        int[] record=new int[26];
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        for(int i=0;i<magazine.length();i++){
            record[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(--record[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
}

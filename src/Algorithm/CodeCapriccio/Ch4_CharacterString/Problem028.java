package Algorithm.CodeCapriccio.Ch4_CharacterString;

/**
 * @author jmjtc
 */
public class Problem028 {
    public static void main(String[] args) {
        System.out.println(new Problem028().strStr1("aabaabaafa","abababab"));
    }
    public int strStr(String haystack, String needle) {
        int ans=-1;
        boolean flag;
        for(int i=0;i<haystack.length();i++){
            flag=true;
            int count=0;
            if(haystack.charAt(i)==needle.charAt(count)){
                for(int j=1;j<needle.length();j++){
                    if(i+j>=haystack.length()||haystack.charAt(i+j)!=needle.charAt(j)){
                        flag=false;
                        break;
                    }
                }
            }else{
                flag=false;
            }
            if(flag){
                ans=i;
                break;
            }
        }
        return ans;
    }


    //前缀表（不减一）Java实现
    public int strStr1(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {//向前查找
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;

    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }
}

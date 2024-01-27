package Algorithm.CodeCapriccio.Ch4_CharacterString;

/**
 * @author jmjtc
 */
public class Problem028 {
    public static void main(String[] args) {
        System.out.println(new Problem028().strStr("leetcode","leeto"));
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
}

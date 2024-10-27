package algorithm.code_capriccio.Ch4_CharacterString;

/**
 * @author jmjtc
 */
public class Problem151 {
    public static void main(String[] args) {
        System.out.println(new Problem151().reverseWords("a"));
    }
    public String reverseWords(String s) {
        StringBuilder[] sb=new StringBuilder[s.length()+1];
        int count=0;
        sb[count]=new StringBuilder();
        for(int i=0;i<s.length();i++){
            boolean flag=false;
            while(i<s.length()&&s.charAt(i)!=' '){
                flag=true;
                sb[count].append(s.charAt(i));
                i++;
            }
            if(flag){
                count++;
                sb[count]=new StringBuilder();
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=count-1;i>=0;--i){
            ans.append(sb[i]);
            if(i!=0){
                ans.append(' ');
            }
        }
        return ans.toString();
    }
}

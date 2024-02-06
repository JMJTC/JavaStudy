package Algorithm.CodeCapriccio.Ch5_DoublePointMethod;

/**
 * @author jmjtc
 */
public class Problem151 {
    public static void main(String[] args) {
        Problem151 test=new Problem151();
        test.removeSpace("  12323  12   ");
        test.reverseString(new StringBuilder("abcdefg"),0,6);
        System.out.println(test.reverseWords("the sky is blue"));
    }
    public String reverseWords(String s){
        StringBuilder sb=removeSpace(s);
        //反转整个字符串
        reverseString(sb,0,sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }
    public StringBuilder removeSpace(String s){
        int l=0,r=s.length()-1;
        while(s.charAt(l)==' '){
            l++;
        }
        while(s.charAt(r)==' '){
            r--;
        }
        StringBuilder sb=new StringBuilder();
        while(l<=r){
            if(s.charAt(l)!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(s.charAt(l));
            }
            l++;
        }
        return sb;
    }

    public void reverseString(StringBuilder sb,int l,int r){
        while(l<r){
            char temp=sb.charAt(l);
            sb.setCharAt(l,sb.charAt(r));
            sb.setCharAt(r,temp);
            l++;
            r--;
        }
    }
    public void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end-1);
            start = end + 1;
            end = start + 1;
        }
    }
}

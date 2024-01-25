package Algorithm.CodeCapriccio.Ch4_CharacterString;

import java.util.Arrays;

/**
 * @author jmjtc
 */
public class Problem541 {
    public static void main(String[] args) {
        System.out.println(new Problem541().reverseStr("abcdefg",2));
    }

    public String reverseStr(String s, int k) {
        StringBuilder ans=new StringBuilder(s);
        //取大整
        int count=s.length()/(2*k);
        if(s.length()%(2*k)!=0){
            count++;
        }
        for(int i=0;i<count;i++){
            int l=2*k*i,r=k*(2*i+1)-1;
            if(r>s.length()-1){
                r=s.length()-1;
            }
            while(l<r){
                char temp=ans.charAt(l);
                ans.setCharAt(l,ans.charAt(r));
                ans.setCharAt(r,temp);
                l++;
                r--;
            }
        }
        return ans.toString();
    }
}

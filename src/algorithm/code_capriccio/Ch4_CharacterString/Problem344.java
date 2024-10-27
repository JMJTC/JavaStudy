package algorithm.code_capriccio.Ch4_CharacterString;

/**
 * @author jmjtc
 */
public class Problem344 {
    public static void main(String[] args) {

    }
    public void reverseString(char[] s) {
        char temp;
        int l=0,r=s.length-1;
        while(l<r){
            temp=s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }

    }
}

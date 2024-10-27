package algorithm.code_capriccio.Ch5_DoublePointMethod;

/**
 * @author jmjtc
 */
public class Problem344 {
    public static void main(String[] args) {
    }
    public void reverseString(char[] s){
        int l=0,r=s.length-1;
        while(l<r){
            char temp=s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }
    }

}

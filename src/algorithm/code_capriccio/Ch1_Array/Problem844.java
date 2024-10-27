package algorithm.code_capriccio.Ch1_Array;

/**
 * @author jmjtc
 */
public class Problem844 {
    public static void main(String[] args) {

    }
}

//不必将字符串转化为字符数组，将空间复杂度降为O(1)
//在重构字符串上，还可以使用栈的数据结构，碰到'#'，已有元素出栈
class Problem844_Solution{
    public boolean backspaceCompare(String s, String t){
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        int length1=realString(s1);
        int length2=realString(t1);
        if(length2!=length1){
            return false;
        }
        for(int i=0;i<length1;i++){
            if(s1[i]!=t1[i]){
                return false;
            }
        }
        return true;
    }

    public int realString(char[] c){
        int fast=0,slow=0;
        while(fast<c.length){
            if(c[fast]!='#'){
                c[slow++]=c[fast];
            }else{
                if(slow!=0){
                    slow--;
                }
            }
            fast++;
        }
        return slow;
    }
}

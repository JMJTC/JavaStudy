package algorithm.code_capriccio.Ch10_DynamicProgramming;

/**
 * @author jmjtc
 */
public class Problem509 {
    public static void main(String[] args) {

    }

    public int fib(int n) {
        int ans=0;
        int a0=0,a1=1;
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        for(int i=0;i<n;i++){
            ans=a0+a1;
            a0=a1;
            a1=ans;
        }
        return ans;
    }
}

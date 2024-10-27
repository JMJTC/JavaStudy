package algorithm.code_capriccio.Ch3_HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jmjtc
 */
public class Problem202 {
    public boolean isHappy(int n) {
        Set<Integer> record=new HashSet<>();
        while(true){
            record.add(n);
            n=getSum(n);
            if(record.contains(n)){
                return false;
            }
            if(n==1){
                return true;
            }
        }
    }
    public int getSum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
}

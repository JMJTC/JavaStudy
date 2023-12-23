package Algorithm.CodeCapriccio.Ch1_Array;

/**
 * @author jmjtc
 */
public class Problem69 {
    public static void main(String[] args) {

    }
}

//注意数据的范围
class Problem69_Solution{
    public int mySqrt(int x) {
        long left=1,right=x;
        while(left<right){
            long mid=left+((right-left)>>1);
            if(mid*mid>=x){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        if(left*left==x){
            return (int)left;
        }else{
            return (int)left-1;
        }
    }
}
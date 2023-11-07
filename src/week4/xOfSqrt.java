package week4;

/**
 * @author jmjtc
 */
public class xOfSqrt {
    public static int mySqrt(int x) {
        int left=1;
        int right=1<<17;
        int mid=(right-left>>1)+left;
        int ans=mid;
        while(left<=right){
            mid=(right-left>>1)+left;
            if((long)mid*mid>x){//避免溢出
                right=mid-1;
                //考虑最后的ans应该等于什么
                ans=right;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}

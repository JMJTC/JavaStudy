package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-13
 * @Description: 1742. 盒子中小球的最大数量
 * @Version: 1.0
 */
public class Problem1742 {
    public static void main(String[] args) {

    }

    public int countBalls(int lowLimit, int highLimit) {
        int[] box=new int[46];
        int sum=0;
        for(int i=lowLimit;i<=highLimit;i++){
            sum=0;
            int temp=i;
            while(temp>0){
                sum+=temp%10;
                temp/=10;
            }
            box[sum]++;
        }
        int max=0;
        for(int i:box){
            if(max<i){
                max=i;
            }
        }
        return max;
    }
}

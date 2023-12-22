package Algorithm.EveryWeekStudy.week4;

/**
 * @author jmjtc
 */
public class week4_1 {
    public static int findKOr(int[] nums, int k) {
        int ans=0;
        //记录数组中各位数字为一的个数
        //数据范围是int型，所以数组大小定为32
        int[] recordNumberOne=new int[32];
        for(int i=0;i<nums.length;i++){
            //和1按位与
            for(int j=0;j<32;j++){
                if((nums[i]&1)==1){
                    recordNumberOne[j]++;
                }
                //右移
                nums[i]=nums[i]>>1;
            }
        }
        for(int i=0;i<32;i++){
            if(recordNumberOne[i]>=k){
                ans+=1<<i;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums=new int[]{1,2,3,4,5,7};
        System.out.println(findKOr(nums,4));
    }
}

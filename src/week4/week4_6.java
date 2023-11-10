package week4;

/**
 * @author jmjtc
 */
public class week4_6 {
    //时间复杂度太高不可取
    public int totalHammingDistance(int[] nums) {
        int ans=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                ans+=hamming(nums[i],nums[j]);
            }
        }
        return ans;
    }
    public static int hamming(int i,int j){
        //异或 不同位为1；
        int temp=i^j;
        int ans=0;
        for(int n=0;n<32;n++){
            if(temp==0){
                break;
            }
            if((temp&1)==1){
                ans++;
            }
            temp=temp>>1;
        }
        return ans;
    }


    //改进：
    public int totalHammingDistanceOne(int[] nums){
        //定义一个二维数组，记录每一个bit位01出现的次数
        int[][] data=new int[31][2];
        for (int num : nums) {
            for (int j = 0; j < 31; j++) {
                if ((num & 1) == 0) {
                    data[j][0]++;
                } else {
                    data[j][1]++;
                }
                num=num>>1;
            }
        }
        int ans=0;
        for(int i=0;i<31;i++){
            ans+=data[i][0]*data[i][1];
        }
        return ans;
    }


    //优化：
    public int totalHammingDistanceTwo(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}

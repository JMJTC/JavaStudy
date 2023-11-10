package week4;

public class week4_10 {
    public int countTriplets(int[] nums) {
        int max=1<<16;
        int[] cnt=new int[max];
        int ans=0,n=nums.length;
        //先统计i,j
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cnt[nums[i]&nums[j]]++;
            }
        }
        for(int k=0;k<n;k++){
            for(int ij=0;ij<max;ij++){
                if((ij&nums[k])==0){
                    ans+=cnt[ij];
                }
            }
        }
        return ans;
    }
}

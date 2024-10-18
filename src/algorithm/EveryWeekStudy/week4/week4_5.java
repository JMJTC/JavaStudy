package algorithm.EveryWeekStudy.week4;

public class week4_5 {
    public int[] countBitsOne(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<19;j++){//19由log n得来
                if(i<(1<<j)){
                    break;
                }
                if(((i>>j)&1)==1){
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    public int[] countBitsTwo(int n) {
        int[] result=new int[n+1];
        for(int i = 1; i <= n; i++)
        {
            if(i % 2 == 1)
            {
                result[i] = result[i-1] + 1;
            }
            else
            {
                result[i] = result[i/2];
            }
        }

        return result;

    }
}

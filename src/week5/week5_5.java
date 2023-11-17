package week5;

public class week5_5 {
}



class week5_5_Solution1 {
    public int[] finalPrices(int[] prices) {
        int length=prices.length;
        int[] ans=new int[length];
        for(int i=0;i<length;i++){
            int end=i+1;
            while(end<length&&prices[end]>prices[i]){
                end++;
            }
            if(end!=length){
                ans[i]=prices[i]-prices[end];
            }else{
                ans[i]=prices[i];
            }

        }
        return ans;
    }
}

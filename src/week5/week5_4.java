package week5;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class week5_4 {
    public static void main(String[] args){
        List<Integer> maxHeights= Arrays.asList(6,5,3,9,2,7);
        System.out.println(new week5_4_Solution().maximumSumOfHeights(maxHeights));
    }
}

class week5_4_Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans=0;
        int maxIndex=0;
        int temp= Collections.max(maxHeights);
        maxIndex=maxHeights.indexOf(temp);
        ans+= maxHeights.get(maxIndex);
        int left,right,maxNum= maxHeights.get(maxIndex);
        left=right=maxIndex;
        while(left>0){
            int temp1= maxHeights.get(left-1);
            if(temp1<maxNum){
                ans+=temp1;
                maxNum=temp1;
            }else{
                ans+=maxNum;
            }
            left--;
        }
        maxNum= maxHeights.get(maxIndex);
        int length=maxHeights.size();
        while(right<length-1){
            int temp1= maxHeights.get(right+1);
            if(temp1<maxNum){
                ans+=temp1;
                maxNum=temp1;
            }else{
                ans+=maxNum;
            }
            right++;
        }
        return ans;
    }
}

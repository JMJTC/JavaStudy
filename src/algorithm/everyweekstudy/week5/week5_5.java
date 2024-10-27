package algorithm.everyweekstudy.week5;

import java.util.Scanner;
import java.util.Stack;

public class week5_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    }
}


//暴力遍历
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

//单调栈
class week5_5_Solution2{
    public int[] finalPrices(int[] prices) {
        //单调栈存数据的下标索引
        Stack<Integer> stack=new Stack<>();
        int length=prices.length;
        for(int i=0;i<prices.length;i++){
            int num=prices[i];
            while(!stack.isEmpty()&&num<=prices[stack.peek()]){
                //出栈，记录索引
                int index=stack.pop();
                prices[index]=prices[index]-num;
            }
            //索引i入栈
            stack.push(i);
        }
        return prices;
    }
}

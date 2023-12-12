package EveryWeekStudy.week5;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class week5_4 {
    public static void main(String[] args){
        List<Integer> maxHeights= Arrays.asList(6,5,3,9,2,7);
        System.out.println(new week5_4_Solution2().maximumSumOfHeights(maxHeights));
    }
}

class week5_4_Solution1{
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long maxH = 0;
        int len = maxHeights.size();
        // 枚举 分别计算峰值在i处时所能达到的美丽塔的最大高度和
        for(int i = 0;i < len;i++){
            long sum = 0;
            // h就是本轮枚举最大峰值，即所有塔高度不能超过h
            int h = maxHeights.get(i);
            int l = i - 1;
            int r = i + 1;
            int left = h,right = h;
            // 从i出发，依次遍历i前面的塔
            while(l >= 0){
                sum += Math.min(maxHeights.get(l),left);
                // left维护i前面的塔的最高高度
                left = Math.min(maxHeights.get(l),left);
                l--;
            }
            // 加上i处的塔的高度
            sum += h;
            // 从i出发，依次遍历i后面的塔
            while(r < len){
                sum += Math.min(maxHeights.get(r),right);
                // right维护i后面的塔的最高高度
                right = Math.min(maxHeights.get(r),right);
                r++;
            }
            maxH = Math.max(maxH,sum);
        }
        return maxH;
    }
}

class week5_4_Solution2{
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int size=maxHeights.size();
        //left,right记录峰值i左右两边数的和
        long[] left=new long[size];
        long[] right=new long[size];
        //两个单调栈，记录索引
        Stack<Integer> lft=new  Stack<>();
        Stack<Integer> rht=new Stack<>();
        //遍历maxHeights,
        //左
        for(int i=0;i<size;i++){
            int heightGet=maxHeights.get(i);
            if(i==0){
                //第一个元素直接入栈
                left[i]=heightGet;
                lft.push(i);
            }else{
                int peek=lft.peek();
                //维护栈的单调性
                while(peek!=-1&&heightGet<=maxHeights.get(peek)){
                    lft.pop();
                    peek=lft.isEmpty()?-1: lft.peek();
                }
                left[i]=(peek==-1?0:left[peek])+ (long) (i - peek) *heightGet;
                lft.push(i);
            }
        }
        //右
        for(int i=size-1;i>=0;i--){
            int heightGet=maxHeights.get(i);
            if(i==size-1){
                //第一个元素直接入栈
                right[i]=heightGet;
                rht.push(i);
            }else{
                int peek=rht.peek();
                //维护栈的单调性
                while(peek!=size&&heightGet<=maxHeights.get(peek)){
                    rht.pop();
                    peek=rht.isEmpty()?size: rht.peek();
                }
                right[i]=(peek==size?0:right[peek])+ (long) (peek - i) *heightGet;
                rht.push(i);
            }
        }
        long ans=0;
        for(int i=0;i<size;i++){
            //重复的减去
            int heightGet=maxHeights.get(i);
            ans=Math.max(ans,right[i]+left[i]-heightGet);
        }
        return ans;
    }
}

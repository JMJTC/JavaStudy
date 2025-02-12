package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-12
 * @Description: 代码 测试用例 测试用例 测试结果   1760. 袋子里最少数目的球
 * @Version: 1.0
 */
public class Problem1760 {
    public static void main(String[] args) {

    }
    public int minimumSize(int[] nums, int maxOperations) {
        int max=0;
        for(int x:nums){
            max=Math.max(max,x);
        }

        //开区间or 闭区间
        int left=1;//循环不变量 check(left)==false
        int right=max;//循环不变量 check(right)==true

        while(left<=right){
            int mid=(left+right)>>>1;//逻辑右移
            if(check(nums,maxOperations,mid)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    private boolean check(int[] nums,int maxOperations,int m){
        long count=0;
        for(int x:nums){
            count+=(x-1)/m;
        }
        return count<=maxOperations;
    }
}

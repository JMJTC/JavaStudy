package algorithm.code_capriccio.Ch9_GreedyAlgorithm;

/**
 * @author jmjtc
 */
public class Problem45 {
    public static void main(String[] args) {
        new Problem45().jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3});
    }
    //贪心算法
    public int jump(int[] nums) {
        int steps=0;//记录跳跃步数
        int maxPosition=0;//记录当前能跳到的最远位置
        int end=0;
        for(int i=0;i<nums.length-1;i++){
            maxPosition=Math.max(maxPosition,i+nums[i]);//更新能跳到的最远位置
            if(i==end){//如果当前位置已经到达了能跳到的最远位置，则跳跃一步
                steps++;//跳跃一步
                end=maxPosition;
            }
        }
        return steps;
    }
}

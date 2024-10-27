package algorithm.code_capriccio.Ch9_GreedyAlgorithm;

/**
 * @author jmjtc
 */
public class Problem134 {
    public static void main(String[] args) {

    }

    //暴力
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] record = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            record[i] = gas[i] - cost[i];
        }
        int total = 0;
        int start = 0;
        for(start = 0; start < gas.length; start++){
            if(record[start]<0){
                continue;
            }
            for(int i=0;i<gas.length;i++){
                total+=record[(start+i)%gas.length];
                if(total<0){
                    total=-1;
                    break;
                }
            }
            if(total>=0){
                return start;
            }
        }
        return -1;
    }


    //贪心1
    public int canCompleteCircuit1(int[] gas, int[] cost){
        int min=Integer.MAX_VALUE;
        int curSum=0;//当前油量

        for(int i=0;i<gas.length;i++){
            int rest=gas[i]-cost[i];
            curSum+=rest;
            if(curSum<min){
                min=curSum;
            }
        }
        if(curSum<0){//不可能跑完全程
            return -1;
        }
        if(min>=0){//全程未断油
            return 0;
        }
        for(int i=gas.length-1;i>=0;i--){
            int rest=gas[i]-cost[i];
            min+=rest;
            if(min>=0){
                return i;
            }
        }
        return -1;
    }

    //贪心2
    public int canCompleteCircuit2(int[] gas, int[] cost){
        int curSum=0;
        int start=0;
        int sum=0;
        for(int i=0;i<gas.length;i++){
            int rest=gas[i]-cost[i];
            curSum+=rest;
            sum+=rest;
            if(curSum<0){
                start=i+1;
                curSum=0;
            }
        }
        if(sum<0){
            return -1;
        }else{
            return start;
        }
    }
}

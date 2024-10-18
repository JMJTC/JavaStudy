package algorithm.LeetCode;

/**
 * @author jmjtc
 */
public class Problem2960 {
    public static void main(String[] args) {

    }

    //方一 遍历
    public int countTestedDevices(int[] batteryPercentages) {
        int ans=0;
        for(int i=0;i<batteryPercentages.length;i++){
            if(batteryPercentages[i]>0){
                ans++;
                for(int j=i+1;j<batteryPercentages.length;j++){
                    batteryPercentages[j]=Math.max(0,batteryPercentages[j]-1);
                }
            }
        }
        return ans;
    }

    //方二 差分
    public int countTestedDevices2(int[] batteryPercentages) {
        int need=0;
        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage > need) {
                need++;
            }
        }
        return need;
    }
}




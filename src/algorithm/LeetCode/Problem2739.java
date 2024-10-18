package algorithm.LeetCode;

/**
 * @author jmjtc
 */
public class Problem2739 {
    public static void main(String[] args) {

    }
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans=0;
        while(mainTank>0){
            if(mainTank>=5){
                ans+=50;
                mainTank-=5;
                if(additionalTank>0){
                    mainTank++;
                }
            }else{
                ans+=mainTank*10;
                break;
            }
        }
        return ans;
    }
}

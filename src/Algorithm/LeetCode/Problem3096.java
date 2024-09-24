package Algorithm.LeetCode;

/**
 * @author jmjtc
 */
public class Problem3096 {
    public static void main(String[] args) {

    }

    public int minimumLevels(int[] possible) {
        double sum=0;
        for(int i=0;i<possible.length;i++){
            if(possible[i]==0){
                possible[i]=-1;
            }
            sum+=possible[i];
        }
        int score=0;
        int ans=0;
        boolean flag=false;
        for(int i=0;i<possible.length;i++){
            ans++;
            score+=possible[i];
            if(score>(sum/2)&&i<possible.length-1){
                flag=true;
                break;
            }
        }
        if(flag){
            return ans;
        }
        return -1;
    }
}

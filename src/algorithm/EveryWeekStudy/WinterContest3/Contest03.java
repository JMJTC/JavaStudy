package algorithm.EveryWeekStudy.WinterContest3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest03 {
    public static int getMaxCount(int[] nums){
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i:nums){
            hash.put(i,hash.getOrDefault(i,0)+1);
        }
        int ans=1;
        //注意1
        //tips:运算符优先级，搞不清楚时加个括号，防止意外
        if(hash.containsKey(1)){
            ans=hash.get(1)-(hash.get(1)%2==0?1:0);
        }
        int max =Integer.MAX_VALUE;
        for(int i:nums){
            if(i==1){
                continue;
            }
            long val=i;
            int res=0,length=0;
            while(val<=max&& hash.containsKey((int) val)){
                res=length*2+1;
                if(hash.get((int)val)==1){
                    break;
                }
                val=val*val;
                length++;
            }
            ans=Math.max(ans,res);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        System.out.println(getMaxCount(nums));
    }
}

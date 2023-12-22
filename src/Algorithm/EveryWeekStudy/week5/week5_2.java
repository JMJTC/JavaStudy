package Algorithm.EveryWeekStudy.week5;

import java.util.Arrays;

/**
 * @author jmjtc
 */
public class week5_2 {
}


//超时，不可取
class week5_2_Solution1 {
    public boolean isContain(int target,int r,int[] heaters){
        int length=heaters.length;
        for(int i=0;i<length;i++){
            if((target<=heaters[i]&&target+r>=heaters[i])||(target>=heaters[i]&&target-r<=heaters[i])){
                return true;
            }
        }
        return false;
    }
    public int findRadius(int[] houses, int[] heaters) {
        //先排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans=0;
        int lengthHouses=houses.length;
        int lengthHeaters=heaters.length;
        for(int i=0;i<lengthHouses;i++){
            while(!isContain(houses[i],ans,heaters)){
                ans++;
            }
        }
        return ans;
    }
}

class week5_2_Solution2 {

    public int findRadius(int[] houses, int[] heaters) {
        //先排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans=0;
        int lengthHouses=houses.length;
        int lengthHeaters=heaters.length;
        //双指针法
        //房子
        int nodeOne=0;
        //加热器
        int nodeTwo=0;
        while(nodeOne<lengthHouses&&nodeTwo<lengthHeaters-1){
            //tmp1.tmp2记录相邻两个加热点到房子的距离，取绝对值
            int tmp1=heaters[nodeTwo]-houses[nodeOne];
            tmp1=tmp1>0?tmp1:-tmp1;
            int tmp2=heaters[nodeTwo+1]-houses[nodeOne];
            tmp2=tmp2>0?tmp2:-tmp2;
            if(tmp1>tmp2){
                nodeTwo++;
                continue;
            }else if(tmp1<tmp2){
                ans=Math.max(tmp1,ans);
                nodeOne++;
            }else{
                ans=Math.max(tmp1,ans);
                nodeOne++;
                nodeTwo++;
            }
        }
        //特殊情况
        if(nodeTwo==lengthHeaters-1&&nodeOne!=lengthHouses){
            ans=Math.max(ans,Math.abs(houses[lengthHouses-1]-heaters[nodeTwo]));
            ans=Math.max(ans,Math.abs(houses[nodeOne]-heaters[nodeTwo]));
        }
        return ans;
    }
}

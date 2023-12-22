package Algorithm.EveryWeekStudy.week8;

import java.util.HashMap;

/**
 * @author jmjtc
 */
public class week8_1584 {
}

class wee8_1584_Solution {
    public int minCostConnectPoints(int[][] points) {
        int res=0;
        int numPoint=points.length;
        int[] record=new int[numPoint];
        int min=Integer.MAX_VALUE;
        int key1=0,key2=0;
        //Hash表记录两点距离
        HashMap<int [],Integer> recordDistance=new HashMap<>();
        //计算两点距离
        for(int i=0;i<numPoint;i++){
            for(int j=i+1;j<numPoint;j++){
                //两个点的距离
                int distance=Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1]);
                recordDistance.put(new int[]{i,j},distance);
                if(min>distance){
                    min=distance;
                    key1=i;
                    key2=j;
                }
            }
        }
        for(int i=0;i<numPoint-1;i++){
            res+=min;
        }
        return res;
    }

}

package EveryWeekStudy.week8;

import java.util.HashMap;

/**
 * @author jmjtc
 */
public class week8_210 {
    public static void main(String[] args) {
        int min=Integer.MAX_VALUE;
        HashMap<int [],Integer> recordDistance=new HashMap<>();
        recordDistance.put(new int[]{1,2},1);
        new Solution().findOrder(3,new int[][]{{0,1},{0,2},{1,2}});
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans=new int[numCourses];
        int[] inDegree=new int[numCourses];
        //初始化每个节点的入度
        for(int i=0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][0]]++;
        }
        for(int i=0,index=0;i<numCourses;){
            if(inDegree[i]==0){
                ans[index++]=i;
                inDegree[i]=-1;
                for(int j=0;j<prerequisites.length;j++){
                    if(prerequisites[j][1]==i)
                        inDegree[prerequisites[j][0]]--;
                }
                i=0;
                continue;
            }
            i++;
        }

        //判断是否有回路
        for(int i=0;i<ans.length;i++){
            for(int j=i+1;j<ans.length;j++){
                if(ans[i]==ans[j]){
                    return new int[0];
                }
            }
        }

        return ans;
    }
}

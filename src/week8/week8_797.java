package week8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmjtc
 */
public class week8_797 {
    public static void main(String[] args) {
    }
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        if(graph[0].length==0){
            return ans;
        }

//        int lengthGraph=graph.length;
//
//        temp.add(0);
//        for(int i=0;i<graph[0].length;i++){
//            temp.add(graph[0][i]);
//            for(int j=1;j<lengthGraph;j++){
//                if(graph[0][i]!=j){
//                    continue;
//                }
//                for(int k=j;k<graph[k].length;k++){
//
//                }
//            }
//        }
        temp.add(0);
        for(int i=0;i<graph[0].length;i++){
            dfs(graph[0][i],graph);
        }
        return ans;
    }
    public void dfs(int i,int[][] graph){
        temp.add(i);
        if(i==graph.length-1){
            ans.add(temp);
            temp.clear();
            return;
        }
        if(graph[i].length!=0){
            for(int j=0;j<graph[i].length;j++){
                dfs(graph[i][j],graph);
            }
        }
    }

}

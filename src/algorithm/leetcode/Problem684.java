package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-27
 * @Description: 冗余连接
 * <a>https://leetcode.cn/problems/redundant-connection/description/</a>
 * @Version: 1.0
 */
public class Problem684 {
    public static void main(String[] args) {
       int[][] edges={{1,5},{2,4},{3,4},{1,3},{3,5}};
       new Problem684().findRedundantConnection(edges);

    }

    public int[] findRedundantConnection(int[][] edges) {
        int length=edges.length;
        int[] data=new int[length+1];
        for(int i=0;i<length+1;i++){
            data[i]=i;
        }
        int[] ans=new int[2];
        for(int i=0;i<length;i++){
            int n=edges[i][0];
            int m=edges[i][1];
            if(data[n]!=data[m]){
                int temp=data[n];
                for(int j=0;j<length+1;j++){
                    if(data[j]==temp){
                        data[j]=data[m];
                    }
                }
            }else{
                ans=new int[]{n,m};
            }
        }
        return ans;
    }
}


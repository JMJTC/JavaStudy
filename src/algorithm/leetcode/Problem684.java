package algorithm.leetcode;

import java.util.Arrays;

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
       int[] ans=new Problem684().findRedundantConnection(edges);
       System.out.println(Arrays.toString(ans));
    }

    //并查集
    public int[] findRedundantConnection(int[][] edges) {
        // 获取边的数量
        int length=edges.length;
        // 创建一个数组，用于存储每个节点的父节点
        int[] data=new int[length+1];
        // 初始化数组，每个节点的父节点初始化为其自身
        for(int i=0;i<length+1;i++){
            data[i]=i;
        }
        // 创建一个数组，用于存储结果
        int[] ans=new int[2];
        // 遍历每条边
        for(int i=0;i<length;i++){
            // 获取边的两个节点
            int n=edges[i][0];
            int m=edges[i][1];
            // 如果两个节点的父节点不同，则将其中一个节点的父节点设置为另一个节点的父节点
            if(data[n]!=data[m]){
                int temp=data[n];
                // 遍历整个数组，将父节点为temp的节点的父节点设置为m
                for(int j=0;j<length+1;j++){
                    if(data[j]==temp){
                        data[j]=data[m];
                    }
                }
            }else{
                // 如果两个节点的父节点相同，则说明这条边是冗余的，将其存储在结果数组中
                ans=new int[]{n,m};
            }
        }
        // 返回结果数组
        return ans;
    }

    public int[] findRedundantConnection2(int[][] edges) {
        // 获取边的数量
        int length=edges.length;
        // 创建一个数组，用于存储每个节点的父节点
        int[] parent=new int[length+1];
        // 初始化数组，每个节点的父节点初始化为其自身
        for(int i=0;i<length+1;i++){
            parent[i]=i;
        }
        // 创建一个数组，用于存储结果
        int[] ans=new int[2];
        // 遍历每条边
        for(int i=0;i<length;i++){
            int n=edges[i][0];
            int m=edges[i][1];
            // 如果两个节点的父节点不同，则将其中一个节点的父节点设置为另一个节点的父节点
            if(find(parent,n)!=find(parent,m)){
                union(parent,n,m);
            }else{
                ans=new int[]{n,m};
            }
        }
        // 返回结果数组
        return ans;
    }

    public int find(int[] parent,int index){
        // 如果当前节点的父节点不是自己，则递归查找父节点
        if(parent[index]!=index){
            parent[index]=find(parent,parent[index]);
        }
        // 返回当前节点的父节点
        return parent[index];
    }

    public void union(int[] parent,int index1,int index2){
        // 将index1的父节点指向index2的父节点
        parent[find(parent,index1)]=find(parent,index2);
    }
}


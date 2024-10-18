package algorithm.CodeCapriccio.Ch12_GraphTheory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem797 {
    //声明一个List类型的变量ans，用于存储最终结果
    private List<List<Integer>> ans = new ArrayList<>();
    //声明一个List类型的变量path，用于存储当前路径
    private List<Integer> path = new ArrayList<>();

    //主函数，用于测试
    public static void main(String[] args) {

    }

    //函数allPathsSourceTarget，用于获取从源点到目标点的所有路径
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //将源点0添加到路径中
        path.add(0);
        //从源点0开始深度优先搜索
        dfs(graph, 0);
        //返回所有路径
        return ans;
    }

    //函数dfs，用于深度优先搜索
    private void dfs(int[][] graph, int cur) {
        //如果当前节点是目标节点
        if (cur == graph.length - 1) {
            //将当前路径添加到结果中
            ans.add(new ArrayList<>(path));
            //返回
            return;
        }
        //遍历当前节点所链接的所有节点
        for (int i = 0; i < graph[cur].length; i++) {
            //将当前节点添加到路径中
            path.add(graph[cur][i]);
            //深度优先搜索
            dfs(graph, graph[cur][i]);
            //回溯
            path.remove(path.size() - 1);
        }
    }
}

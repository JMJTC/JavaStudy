package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jmjtc
 */
public class Problem2385 {
    private TreeNode startNode;
    private final Map<TreeNode,TreeNode> fa=new HashMap<>();

    public  int amountOfTime(TreeNode root, int start){
        dfs(root,null,start);
        return maxDepth(startNode,startNode);
    }

    public void dfs(TreeNode node,TreeNode from,int start){
        if(node==null){
            return;
        }

        fa.put(node,from);//记录每个父节点

        if(node.val==start){
            startNode=node;//找到start
        }

        dfs(node.left,node,start);
        dfs(node.right,node,start);
    }

    public int maxDepth(TreeNode node,TreeNode from){
        if(node==null){
            return -1;//start的深度为0
        }
        int res=-1;
        if(node.left!=from){
            res=Math.max(res,maxDepth(node.left,node));
        }
        if(node.right!=from){
            res=Math.max(res,maxDepth(node.right,node));
        }
        if(fa.get(node)!=from){
            res=Math.max(res,maxDepth(fa.get(node),node));
        }
        return res+1;
    }
}

package algorithm.CodeCapriccio.Ch7_BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jmjtc
 */
public class Problem111 {
    public static void main(String[] args) {

    }


//    dfs
    public int minDepth1(TreeNode root){
        // 如果根节点为空，则返回0
        if (root == null) {
            return 0;
        }

        // 如果根节点的左子节点和右子节点都为空，则返回1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 初始化最小深度为Integer.MAX_VALUE
        int min_depth = Integer.MAX_VALUE;

        // 如果根节点的左子节点不为空，则更新最小深度
        if (root.left != null) {
            min_depth = Math.min(minDepth1(root.left), min_depth);
        }

        // 如果根节点的右子节点不为空，则更新最小深度
        if (root.right != null) {
            min_depth = Math.min(minDepth1(root.right), min_depth);
        }

        // 返回最小深度加1
        return min_depth + 1;
    }

    //bfs
    public int minDepth2(TreeNode root){
        if(root==null){
            return 0;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int ans=Integer.MAX_VALUE;
        int record=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean flag=true;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left==null&&node.right==null){
                    flag=false;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            record++;
            if(!flag){
                ans=Math.min(ans,record);
            }
        }
        return ans;
    }
}

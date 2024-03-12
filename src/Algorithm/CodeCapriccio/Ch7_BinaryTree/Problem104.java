package Algorithm.CodeCapriccio.Ch7_BinaryTree;

import java.util.Deque;
import java.util.LinkedList;



/**
 * @author jmjtc
 */
public class Problem104 {
    public static void main(String[] args) {

    }

    //bfs
    public int maxDepth1(TreeNode root){
        // 如果根节点为空，则返回0
        if(root==null){
            return 0;
        }
        // 定义一个变量ans来存储最大深度
        int ans=0;
        // 创建一个队列用来存储节点
        Deque<TreeNode> queue=new LinkedList<>();
        // 将根节点添加到队列中
        queue.offer(root);
        // 当队列不为空时
        while(!queue.isEmpty()){
            // 深度加1
            ans++;
            // 获取队列的大小
            int size= queue.size();
            // 遍历队列中的节点
            for(int i=0;i<size;i++){
                // 从队列中取出节点
                TreeNode node=queue.poll();
                // 如果节点的左子节点不为空，则将其添加到队列中
                if(node.left!=null){
                    queue.offer(node.left);
                }
                // 如果节点的右子节点不为空，则将其添加到队列中
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }

        }
        // 返回最大深度
        return ans;
    }

    //dfs
    public int maxDepth2(TreeNode root){
        // 递归终止条件
        if(root==null){
            return 0;
        }else{
            // 递归调用
            int leftHeight=maxDepth2(root.left)+1;
            int rightHeight=maxDepth2(root.right)+1;
            // 返回左右子树高度的最大值
            return Math.max(leftHeight,rightHeight);
        }
    }
}

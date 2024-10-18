package algorithm.CodeCapriccio.Ch7_BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem102 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        //定义一个二维列表ans，用于存放每一层的节点值
        List<List<Integer>> ans=new ArrayList<>();
        //定义一个队列queue，用于存放节点
        Deque<TreeNode> queue=new LinkedList<>();
        //如果根节点为空，直接返回ans
        if(root==null){
            return ans;
        }
        //将根节点入队
        queue.offer(root);
        //当队列不为空时，进行循环
        while(!queue.isEmpty()){
            //获取当前队列的长度，用于循环遍历队列中的节点
            int size= queue.size();
            //定义一个临时列表temp，用于存放当前层的节点值
            List<Integer> temp=new ArrayList<>();
            //循环遍历队列中的节点
            for(int i=0;i<size;i++){
                //出队一个节点
                TreeNode node=queue.poll();
                //将该节点的值添加到temp列表中
                temp.add(node.val);
                //如果该节点有左子节点，将左子节点入队
                if(node.left!=null){
                    queue.offer(node.left);
                }
                //如果该节点有右子节点，将右子节点入队
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            //将temp列表添加到ans列表中
            ans.add(temp);
        }
        //返回ans列表
        return ans;
    }
}

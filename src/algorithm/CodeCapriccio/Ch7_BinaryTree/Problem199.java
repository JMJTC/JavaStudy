package algorithm.CodeCapriccio.Ch7_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jmjtc
 */
public class Problem199 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        //层序遍历
        if(root==null) {
            return ans;
        }

        //将根节点加入队列
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            //遍历当前层
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                //每层最后一个节点就是我们要找的
                if(i==size-1){
                    ans.add(node.val);
                }
                //将当前节点的子节点加入队列
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
}

package algorithm.CodeCapriccio.Ch7_BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem637 {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root){
        List<Double> ans=new ArrayList<>();
        if(root==null) {
            return ans;
        }
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            ans.add(sum/size);
        }
        return ans;
    }

}

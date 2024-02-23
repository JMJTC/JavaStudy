package Algorithm.CodeCapriccio.Ch7_BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jmjtc
 */
public class TraversingBinaryTree {
    List<Integer> ans=new ArrayList<>();
    public static void main(String[] args) {

    }

    //前序
    //递归遍历
    public List<Integer> preorderTraversal(TreeNode root){
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return ;
        }
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    //迭代法
    public List<Integer> preorderTraversal1(TreeNode root){
        if(root==null){
            return null;
        }
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            TreeNode node=deque.pop();
            ans.add(node.val);
            if(node.right!=null){
                deque.push(node.right);
            }
            if(node.left!=null){
                deque.push(node.left);
            }
        }
        return ans;
    }
}

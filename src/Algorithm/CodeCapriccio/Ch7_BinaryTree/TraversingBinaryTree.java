package Algorithm.CodeCapriccio.Ch7_BinaryTree;

import java.util.*;

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
        //前序
        //ans.add(root.val);
        dfs(root.left);
        //中序
        //ans.add(root.val);
        dfs(root.right);
        //后序
        ans.add(root.val);
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

    //后序
    //递归
    public List<Integer> postorderTraversal(TreeNode root){
        dfs(root);
        return ans;
    }

    //迭代
    public List<Integer> postorderTraversal1(TreeNode root){
        if(root==null){
            return null;
        }
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            TreeNode node=deque.pop();
            ans.add(node.val);
            if(node.left!=null){
                deque.push(node.left);
            }
            if(node.right!=null){
                deque.push(node.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    //中序
    //迭代
    public List<Integer> inorderTraversal(TreeNode root){
        if(root==null){
            return ans;
        }
        Deque<TreeNode> stack=new LinkedList<>();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                //一直访问到最底层
                stack.push(root);
                root=root.left;
            }else{
                root=stack.peek();
                stack.pop();
                ans.add(root.val);
                root=root.right;
            }
        }
        return ans;
    }
}

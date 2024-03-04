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
        //如果根节点为空，则返回null
        if(root==null){
            return null;
        }
        //定义一个队列
        Deque<TreeNode> deque=new LinkedList<>();
        //将根节点入队
        deque.push(root);
        //当队列不为空时
        while(!deque.isEmpty()){
            //出队一个节点
            TreeNode node=deque.pop();
            //将出队的节点的值加入结果集
            ans.add(node.val);
            //如果出队节点的右子节点不为空，则将右子节点入队
            if(node.right!=null){
                deque.push(node.right);
            }
            //如果出队节点的左子节点不为空，则将左子节点入队
            if(node.left!=null){
                deque.push(node.left);
            }
        }
        //返回结果集
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

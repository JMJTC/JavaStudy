package EveryWeekStudy.week6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jmjtc
 */
public class week6_3 {
    public static void main(String[] args) {

    }
}

class week6_3_Solution1 {
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int i){
        if(root==null){
            return 0;
        }
        int ans=i*10+root.val;
        if (root.left == null && root.right == null) {
            return ans;
        }
        return dfs(root.left,ans)+dfs(root.right,ans);
    }
}

class week6_3_Solution2{
    public int sumNumbers(TreeNode root){
        if(root==null){
            return 0;
        }
        int ans=0;
        Queue<TreeNode> queueTree=new LinkedList<>();
        Queue<Integer> queueNumber=new LinkedList<>();
        queueTree.offer(root);
        queueNumber.offer(root.val);
        while(!queueTree.isEmpty()){
            TreeNode node=queueTree.poll();
            int num=queueNumber.poll();
            if(node.left==null&&node.right==null){
                ans+=num;
            }
            if (node.left != null) {
                queueTree.offer(node.left);
                queueNumber.offer(num * 10 + node.left.val);
            }
            if (node.right != null) {
                queueTree.offer(node.right);
                queueNumber.offer(num * 10 + node.right.val);
            }
        }
        return ans;
    }
}
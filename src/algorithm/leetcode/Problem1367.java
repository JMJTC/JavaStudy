package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-12-30
 * @Description: 1367. 二叉树中的链表
 * @Version: 1.0
 */
public class Problem1367 {
    public static void main(String[] args) {

    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null){
            return false;
        }
        return dfs(root,head)||isSubPath(head,root.left)||isSubPath(head,root.right);
    }

    private boolean dfs(TreeNode root,ListNode head){
        //链表结束，匹配成功
        if(head==null){
            return true;
        }
        //二叉树访问到空节点，匹配失败
        if(root==null){
            return false;
        }
        //值不相等
        if(root.val!=head.val){
            return false;
        }
        return dfs(root.left,head.next)||dfs(root.right,head.next);
    }

}

package algorithm.CodeCapriccio.Ch7_BinaryTree;

import java.util.*;

/**
 * @author jmjtc
 */
public class Problem107 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, 0, root);
        return res;
    }


    //定义一个递归方法，用于生成二叉树的层序遍历
    private void dfs(List<List<Integer>> res, int level, TreeNode root) {
        //如果节点为空，直接返回
        if (root == null) {
            return;
        }
        //如果当前层还没有添加到结果集中，则添加当前层
        if (level >= res.size()) {
            res.add(0, new ArrayList<>());
        }
        //将当前节点的值添加到结果集中
        res.get(res.size() - level - 1).add(root.val);
        //递归遍历左子树
        dfs(res, level + 1, root.left);
        //递归遍历右子树
        dfs(res, level + 1, root.right);
    }

    // 层序遍历
    private void bfs(List<List<Integer>> res, TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        Collections.reverse(res);
    }
}

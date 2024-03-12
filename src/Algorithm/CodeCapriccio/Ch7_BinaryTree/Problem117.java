package Algorithm.CodeCapriccio.Ch7_BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jmjtc
 */
public class Problem117 {
    public static void main(String[] args) {

    }

    public Node connect(Node root){
        if(root==null){
            return root;
        }
        Deque<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                if(i<size-1){
                    node.next=queue.peekFirst();
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}

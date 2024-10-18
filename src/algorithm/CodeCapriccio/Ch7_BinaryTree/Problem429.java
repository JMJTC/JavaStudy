package algorithm.CodeCapriccio.Ch7_BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem429 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> tempList=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                tempList.add(node.val);
                for(Node child:node.children){
                    queue.offer(child);
                }
            }
            res.add(tempList);
        }
        return  res;
    }

}

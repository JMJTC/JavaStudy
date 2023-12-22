package Algorithm.EveryWeekStudy.week6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jmjtc
 */
public class week6_1 {
    public static void main(String[] args) {

    }
}

class week6_1Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            while(size>0){
                Node tmp =queue.poll();
                for(Node node:tmp.children){
                    queue.add(node);
                }
                temp.add(tmp.val);
                size--;
            }
            ans.add(temp);
        }
        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
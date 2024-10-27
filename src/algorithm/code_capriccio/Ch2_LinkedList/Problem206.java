package algorithm.code_capriccio.Ch2_LinkedList;

/**
 * @author jmjtc
 */
public class Problem206 {
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    //需要新节点
    public ListNode reverseList(ListNode head) {
        ListNode res=new ListNode();
        while(head!=null){
            ListNode currentNode=new ListNode(head.val);
            currentNode.next=res.next;
            res.next=currentNode;
            head=head.next;
        }
        return res.next;
    }

    //O(n)    O(1)  换指针的朝向即可
    //可以想一下用递归的话该怎么写
    public ListNode reverseList1(ListNode head) {
        ListNode temp;
        ListNode currentNode=head;
        ListNode prev=null;
        while(currentNode!=null){
            temp=currentNode.next;
            currentNode.next=prev;//翻转
            prev=currentNode;
            currentNode=temp;
        }
        return prev;
    }
}

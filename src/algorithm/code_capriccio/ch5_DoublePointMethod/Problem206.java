package algorithm.code_capriccio.ch5_DoublePointMethod;


/**
 * @author jmjtc
 */
public class Problem206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head){
        ListNode temp;
        ListNode currentNode=head;
        ListNode prev=null;
        while(currentNode!=null){
            temp=currentNode.next;
            currentNode.next=prev;
            prev=currentNode;
            currentNode=temp;
        }
        return prev;
    }

    //递归法
    public ListNode reverseList1(ListNode head){
        return reverse(null,head);
    }
    public ListNode reverse(ListNode prev,ListNode currentNode){
        if(currentNode==null){
            return prev;
        }
        ListNode temp=currentNode.next;
        currentNode.next=prev;
        return reverse(currentNode,temp);
    }
}


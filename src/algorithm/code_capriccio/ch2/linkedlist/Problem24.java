package algorithm.code_capriccio.ch2.linkedlist;

/**
 * @author jmjtc
 */
public class Problem24 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        new Problem24().swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode first=head;
        ListNode second=null;
        ListNode temp=null;
        ListNode prev=new ListNode();
        if(first==null||first.next==null){
            return first;
        }
        ListNode res=first.next;
        while(first!=null){
            second=first.next;
            //temp1=second;
            if(second!=null){
                //temp1.next=first;
                temp=second.next;
                second.next=first;
                first.next=temp;
                prev.next=second;
                prev=first;
            }else{
                temp=null;
            }
            first=temp;
        }
        return res;
    }
}

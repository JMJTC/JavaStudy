package Algorithm.CodeCapriccio.Ch5_DoublePointMethod;

/**
 * @author jmjtc
 */
public class Problem019 {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        //虚拟头结点，统一操作
        ListNode prev=new ListNode();
        prev.next=head;
        ListNode r=prev;
        for(int i=0;i<n;i++){
            r=r.next;
        }
        ListNode temp=prev;
        while(r.next!=null){
            r=r.next;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return prev.next;
    }
}

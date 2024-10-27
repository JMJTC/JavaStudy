package algorithm.code_capriccio.Ch2_LinkedList;

/**
 * @author jmjtc
 */
public class Problem203 {
    public static void main(String[] args) {

    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans=new ListNode(0,head);
        ListNode ptr=new ListNode(0);
        ptr=ans;
        while(ptr.next!=null){
            if(ptr.next.val==val){
                ptr.next=ptr.next.next;
            }else{
                ptr=ptr.next;
            }
        }
        return ans.next;
    }

    //递归
    public ListNode removeElementsWithRec(ListNode head, int val){
        if(head==null){
            return null;
        }
        head.next=removeElementsWithRec(head.next,val);
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }
    }
}

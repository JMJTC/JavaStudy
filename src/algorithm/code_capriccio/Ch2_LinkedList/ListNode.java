package algorithm.code_capriccio.Ch2_LinkedList;

/**
 * @author jmjtc
 */
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     public void add(int val){
         ListNode temp=this;
         while(temp.next!=null){
             temp=temp.next;
         }
         temp.next=new ListNode(val);
     }
}

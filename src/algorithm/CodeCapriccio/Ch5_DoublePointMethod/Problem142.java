package algorithm.CodeCapriccio.Ch5_DoublePointMethod;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jmjtc
 */
public class Problem142 {
    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head){
        Set<ListNode> visited=new HashSet<>();
        ListNode temp=head;
        while(temp!=null){
            if(visited.contains(temp)){
                return temp;
            }
            visited.add(temp);
            temp=temp.next;
        }
        return temp;
    }
    public ListNode detectCycle1(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(true){
            if(fast==null||fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}

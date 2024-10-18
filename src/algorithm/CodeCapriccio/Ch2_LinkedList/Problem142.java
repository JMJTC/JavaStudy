package algorithm.CodeCapriccio.Ch2_LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jmjtc
 */
public class Problem142 {
    public static void main(String[] args) {
        ListNode test=new ListNode(0);
        test.add(1);
        test.add(2);
        test.next.next.next=test.next;
        new Problem142().detectCycle1(test);
    }

    //空间复杂度O(n),利用HashSet
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited=new HashSet<>();
        ListNode temp=head;
        while(temp!=null){
            visited.add(temp);
            temp=temp.next;
            if(visited.contains(temp)){
                return temp;
            }
        }
        return null;
    }

    //快慢指针
    //空间复杂度O(1)
    public ListNode detectCycle1(ListNode head){
        ListNode fast,slow;
        fast=head;slow=head;
        ListNode index1=head,index2;
        while(true){
            if(fast==null){
                return null;
            }
            fast=fast.next;
            if(fast==null){
                return null;
            }
            fast=fast.next;
            slow=slow.next;
            if(fast==slow){
                index2=fast;
                break;
            }
        }
        while(index1!=index2){
            index1=index1.next;
            index2=index2.next;
        }
        return index1;
    }

    //优化后的代码
    public ListNode detectCycle11(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}

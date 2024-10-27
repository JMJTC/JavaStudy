package algorithm.code_capriccio.Ch5_DoublePointMethod;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jmjtc
 */
public class Problem0207 {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode prev1=new ListNode();
        prev1.next=headA;
        ListNode prev2=new ListNode();
        prev2.next=headB;
        int length1=0,length2=0;
        while(prev1.next!=null){
            prev1=prev1.next;
            length1++;
        }
        while(prev2.next!=null){
            prev2=prev2.next;
            length2++;
        }
        //从相同长度的位置开始
        //注意引用相等如何比较
        int begin=length1-length2;
        prev1=headA;
        prev2=headB;
        if(begin>0){
            while(begin>0){
                prev1=prev1.next;
                begin--;
            }
        }else{
            while(begin<0){
                prev2=prev2.next;
                begin++;
            }
        }
        while(prev1!=null){
            if(prev1==prev2){
                return prev1;
            }else{
                prev1=prev1.next;
                prev2=prev2.next;
            }
        }
        return null;
    }

    //方二：利用Set
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        Set<ListNode> visited=new HashSet<>();
        ListNode temp=headA;
        while(temp!=null){
            visited.add(temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if(visited.contains(temp)){
                return temp;
            }
            temp=temp.next;
        }
        return temp;
    }
}

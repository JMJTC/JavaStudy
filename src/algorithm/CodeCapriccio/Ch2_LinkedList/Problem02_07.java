package algorithm.CodeCapriccio.Ch2_LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jmjtc
 */
public class Problem02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int realLength=0;
        ListNode temp=headA;
        int lengthA=0,lengthB=0;
        while(temp!=null){
            lengthA++;
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            lengthB++;
            temp=temp.next;
        }
        realLength=lengthA-lengthB;
        ListNode resA=headA,resB=headB;
        if(realLength>0){
            while(realLength!=0){
                resA=resA.next;
                realLength--;
            }
        }else{
            while(realLength!=0){
                resB= resB.next;
                realLength++;
            }
        }
        while(resA!=null&&resB!=null&&resA.val!=resB.val){//注意是引用比较，而不是比较值
            resB=resB.next;
            resA=resA.next;
        }
        return resA;
    }

    //哈希集合
    //空间复杂度变高了
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

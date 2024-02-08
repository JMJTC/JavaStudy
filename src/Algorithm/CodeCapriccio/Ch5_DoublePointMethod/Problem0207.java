package Algorithm.CodeCapriccio.Ch5_DoublePointMethod;

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
}

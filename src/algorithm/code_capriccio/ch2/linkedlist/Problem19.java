package algorithm.code_capriccio.ch2.linkedlist;

/**
 * @author jmjtc
 */
public class Problem19 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        new Problem19().removeNthFromEnd(head,2);
    }
    //遍历了，两趟
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //整一个头结点，方便操作
        ListNode headNode=new ListNode();
        headNode.next=head;
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        int index=size-n;
        temp=headNode;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return headNode.next;
    }

    //双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。
    // 遍历一趟
    public ListNode removeNthFromEnd1(ListNode head, int n){
        ListNode headNode=new ListNode();
        headNode.next=head;
        ListNode slow=headNode;
        ListNode fast=headNode;
        while(n!=0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return headNode.next;
    }
}

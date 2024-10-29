package algorithm.code_capriccio.ch2.linkedlist;

/**
 * @author jmjtc
 */
public class Problem707 {
    public static void main(String[] args) {
        MyLinkedList test=new MyLinkedList();
        test.addAtHead(2);
        test.addAtTail(3);
    }
}


class MyLinkedList{
    //size存储链表元素个数
    int size;
    //虚拟头结点，统一操作
    ListNode head;
    //初始化链表
    public MyLinkedList(){
        size=0;
        head=new ListNode(0);
    }
    public int get(int index){
        if(index<0||index>=size){
            return -1;
            //不合法则返回-1
        }
        ListNode currentNode=head;
        for(int i=0;i<=index;i++){
            currentNode=currentNode.next;
        }
        return currentNode.val;
    }

    //在链表最前面插入一个节点，等价于在第0个元素前添加
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    public void addAtIndex(int index,int val){
        if(index>size){
            return;
        }
        if(index<0){
            index=0;
        }
        size++;
        //找到要插入节点的前驱
        ListNode currentNode=head;
        for(int i=0;i<index;i++){
            currentNode=currentNode.next;
        }
        ListNode toAdd=new ListNode(val);
        toAdd.next=currentNode.next;
        currentNode.next=toAdd;
    }
    public void deleteAtIndex(int index){
        if(index>=0&&index<size){
            size--;
            ListNode prev=head;
            for(int i=0;i<index;i++){
                prev=prev.next;
            }
            prev.next=prev.next.next;
        }

    }
}

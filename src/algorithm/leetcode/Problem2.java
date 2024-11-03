package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-02
 * @Description: 两数相加
 * @Version: 1.0
 */
public class Problem2 {
    public static void main(String[] args) {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode use = new ListNode();
        pre.next = use;
        int temp = 0;
        while (l1 != null && l2 != null) {
            int temp1 = l1.val + l2.val;
            if (temp1 + temp >= 10) {
                temp1 = temp1 + temp;
                temp = 1;
                temp1 %= 10;
            } else {
                temp = 0;
            }
            use.next = new ListNode();
            use = use.next;
            use.val = temp1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            use.val = l1.val;
            use.next = new ListNode();
            use = use.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            use.val = l2.val;
            use.next = new ListNode();
            use = use.next;
            l2 = l2.next;
        }
        return pre.next.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


// 给定一个链表: 1->2->3->4->5, 和 k = 2.

// 返回链表 4->5.
public class Sword22 {
    ListNode newHead;

    public ListNode getKthFromEnd(ListNode head, int k) {
        getKth(head, k);
        return newHead;
    }

    private int getKth(ListNode head, int k) {
        if (head == null) {
            return 0;
        } else {
            int cur = getKth(head.next, k) + 1;
            if (cur == k)
                newHead = head;
            return cur;
        }
    }

    public static void main(String[] args) {

    }
}

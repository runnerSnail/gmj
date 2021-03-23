public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        if(head.next.next == null) return head;
        ListNode newHead = head.next;
        handleSwapPairs(head);
        return newHead;
    }

    public ListNode handleSwapPairs(ListNode head) {
        if (head != null) {
            if (head.next != null) {
                ListNode second = head.next;
                ListNode third = head.next.next;
                head.next = handleSwapPairs(third);;
                second.next = head;
                return second;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        // ListNode head = solution24.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3))));
        ListNode listNode = new ListNode(3, new ListNode(2, new ListNode(4, new ListNode(5,new ListNode(6,new ListNode(7))))));
        ListNode head = solution24.swapPairs(listNode);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

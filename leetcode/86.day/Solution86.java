public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode big = new ListNode(0);
        ListNode bigHead = big;
        while (head != null) {
            if (head.val < x) {
                smallHead.next = head;
                smallHead = smallHead.next;
            } else {
                bigHead.next = head;
                bigHead = bigHead.next;
            }
            head=head.next;
        }
        smallHead.next = big.next;
        bigHead.next = null;
        return small.next;
    }

    public static void main(String[] args) {

    }
}

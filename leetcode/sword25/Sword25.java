public class Sword25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumy = new ListNode(0);
        ListNode curNode = dumy;
        while (l1 != null && l2 != null) {
            int cur;
            if (l1.val > l2.val) {
                cur = l2.val;
                l2 = l2.next;
            } else {
                cur = l1.val;
                l1 = l1.next;
            }
            curNode.next = new ListNode(cur);
            curNode = curNode.next;
        }
        ;
        if (l1 == null) {
            curNode.next = l2;
        } else {
            curNode.next = l1;
        }
        return dumy.next;
    }

    public static void main(String[] args) {

    }
}

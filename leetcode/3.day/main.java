
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            ListNode current = new ListNode(sum % 10);
            cursor.next = current;
            cursor = cursor.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode l1 = solution.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4))));
        while (l1!=null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}
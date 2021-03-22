// 21. 合并两个有序链表
// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

// 示例 1：

// 输入：l1 = [1,2,4], l2 = [1,3,4]
// 输出：[1,1,2,3,4,4]
// 示例 2：

// 输入：l1 = [], l2 = []
// 输出：[]
// 示例 3：

// 输入：l1 = [], l2 = [0]
// 输出：[0]

// 提示：

// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列

public class Solution20 {
    public ListNode upperListNode(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode head = null;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 == null && l2 == null) {
                return head;
            }
            if (l1 == null) {
                val = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                val = l1.val;
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    val = l2.val;
                    l2 = l2.next;
                } else {
                    val = l1.val;
                    l1 = l1.next;
                }
            }

            if (result == null)
                result = new ListNode(val);
            else {
                result.next = new ListNode(val);
                result = result.next;
            }

            if (head == null) {
                head = result;
            }
        }

        return head;
    }

    // 1 2 3 4
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        int cur = 0;
        head.next = removeNthFromEnd(head.next, n);
        if (cur == n)
            return head.next;
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int l = 0 - n;
        ListNode ans = head;
        ListNode temp = null;
        while (head != null) {
            if (l >= 0) {
                temp = ans;
            }
            l++;
            if (head.next == null) {
                temp = temp.next;
                return ans;
            }
            head = head.next;
            if (temp != null)
                temp = temp.next;
        }
        return null;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        }

    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode result = solution20.upperListNode(l1, new ListNode(1, new ListNode(3, new ListNode(4))));
        ListNode result2 = solution20.removeNthFromEnd1(l1, 2);
        result2 = solution20.upperListNode(null, null);
        result2 = solution20.upperListNode(null, new ListNode(0));
        result2 = solution20.mergeTwoList(l1, new ListNode(1, new ListNode(3, new ListNode(4))));
        while (result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }
    }
}

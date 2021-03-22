import java.util.ArrayList;
import java.util.List;

// 给你一个链表数组，每个链表都已经按升序排列。

// 请你将所有链表合并到一个升序链表中，返回合并后的链表。

//  

// 示例 1：

// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
// 输出：[1,1,2,3,4,4,5,6]
// 解释：链表数组如下：
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// 将它们合并到一个有序链表中得到。
// 1->1->2->3->4->4->5->6
// 示例 2：

// 输入：lists = []
// 输出：[]
// 示例 3：

// 输入：lists = [[]]
// 输出：[]

public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode head = null;
        if (lists.length == 0)
            return null;
        return mergeKListsToOneList(lists, result, head);
    }

    public ListNode mergeKListsToOneList(ListNode[] lists, ListNode result, ListNode head) {
        ListNode min = lists[0];
        int target = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null)
                continue;
            if (min == null) {
                min = lists[i];
                target = i;
            } else if (lists[i].val < min.val) {
                target = i;
                min = lists[i];
            }
        }
        if (min != null) {
            if (result == null) {
                result = min;
                head = result;
            } else {
                result.next = new ListNode(min.val);
                result = result.next;
            }
            lists[target] = min.next;
            return mergeKListsToOneList(lists, result, head);
        }
        return head;
    }

    public static void main(String[] args) {
        List<ListNode> list = new ArrayList();
        list.add(new ListNode(1, new ListNode(4, new ListNode(5))));
        list.add(new ListNode(1, new ListNode(3, new ListNode(4))));
        // list.add(new ListNode(2, new ListNode(6)));
        Solution23 solution23 = new Solution23();
        ListNode nodeList = solution23.mergeKLists(list.toArray(new ListNode[0]));
        while(nodeList!=null){
            System.out.println(nodeList.val);
            nodeList = nodeList.next;
        }
    }
}

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){
            return head;
        }
        int curNum = 0;
        int hasK = 0;
        ListNode curHead = head;
        ListNode tempHead = head;
        while(tempHead!=null){
            hasK++;
            if(hasK==k){
                break;
            }
            tempHead = tempHead.next;
        }
        System.out.println("hasK"+ hasK);
        if(hasK != k){
            return curHead;
        }
        while (head != null) {
            ListNode second = head.next;
            head.next = second.next;
            second.next = curHead;
            curHead = second;
            if (curNum + 2 == k) {
                break;
            }
            curNum++;
        }

        // ListNode temp= curHead;
        // while (temp != null) {
        //     System.out.println(temp.val);
        //     temp = temp.next;
        // }
        // System.out.println("<<<<--->>>>");

        // no k
        if (curNum + 2 < k) {
            return head;
        }

        // in k
        if(head.next!=null) head.next = reverseKGroup(head.next, k);
        else head.next = null;
        return curHead;

    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode listNode = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        // ListNode head = solution25.reverseKGroup(listNode, 3);
        ListNode head  = solution25.reverseKGroup(new ListNode(1,
        new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5))))), 5);
        // ListNode head  = solution25.reverseKGroup(new ListNode(1,
        // new ListNode(2)), 2);
        System.out.println("--->>>>");
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

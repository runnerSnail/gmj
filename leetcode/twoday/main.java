class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        int lastValue = 0;
        boolean first = false;
        while (l1!=null) {
            int current = 0;
            if (l2!=null) {
                current = l1.val + l2.val + lastValue;
                l2 = l2.next;
            } else {
                current = l1.val + lastValue;
            }
            l1 = l1.next;
            if (current >= 10) {
                lastValue = 1;
                current -= 10;
            }else{
                lastValue = 0;
            }
            listNode.val = current;
            if(l1!=null){
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
        }
 
        while (l2!=null) {
            int current = l2.val + lastValue;
            if (current >= 10) {
                lastValue = 1;
                current -= 10;
            }else{
                lastValue = 0;
            }
            listNode.next = new ListNode(current,l2.next==null?null:new ListNode());
            listNode = listNode.next;
            
            l2 = l2.next;
        }
        if(lastValue==1){
            listNode.next = new ListNode(1);
        }
        return head;
    }
}
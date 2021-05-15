public class Sword18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while(cur.next!=null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        
    }
}

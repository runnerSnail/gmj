public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode newHead = head;
        while(head.next!=null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return newHead;
    }
    public static void main(String[] args) {
        
    }
}

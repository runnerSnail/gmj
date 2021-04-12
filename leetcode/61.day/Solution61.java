public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        int n = 1;
        ListNode iter = head;
        while (iter.next!= null) {
            n += 1;
            iter = iter.next;
        }
        if (k % n == 0) {
            return head;
        }
        iter.next = head;
        int add = n - k % n;
        while(add-->0){
            iter = iter.next;
        }
        ListNode newHead =  iter.next.next;
        iter.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int add = 1;
        if(--add>0){
            System.out.println("6666");
        }
    }
}

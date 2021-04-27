public class Soluton109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        while(q!=null && q.next!=null){
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }
        pre.next = null;
        TreeNode current = new TreeNode(p.val);
        current.left = sortedListToBST(head);
        current.right = sortedListToBST(p.next);
        return current;
    }

    public static void main(String[] args) {
        
    }
}

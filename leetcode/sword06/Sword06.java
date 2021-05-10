import java.util.Stack;

public class Sword06 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }
        
        int[] ret = new int[stack.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = stack.pop().val;
        }

        return ret;
    }

    public static void main(String[] args) {

    }
}

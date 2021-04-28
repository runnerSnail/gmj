import java.util.LinkedList;
import java.util.Queue;

/**
 * 1 2 3 4 5 6 8
 */
public class Solution116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                if(i<size-1){
                    curNode.next = queue.peek();
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution116 solution116 = new Solution116();
        // System.out.println(solution116.connect(root));
    }
}

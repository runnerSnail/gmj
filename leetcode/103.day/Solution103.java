import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean readByleft = false;
        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curent = queue.poll();
                if (readByleft) {
                    deque.addFirst(curent.val);
                } else {
                    deque.addLast(curent.val);
                }
                if (curent.left != null) {
                    queue.offer(curent.left);
                }
                if (curent.right != null) {
                    queue.offer(curent.right);
                }
            }
            readByleft = !readByleft;
            list.add(new ArrayList<>(deque));
        }
        return list;
    }

    public static void main(String[] args) {

    }
}

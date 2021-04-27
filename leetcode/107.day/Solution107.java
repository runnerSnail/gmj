import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> ret = new LinkedList<>();
        if (root == null)
            return new ArrayList<>(ret);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();
                curLevel.add(cur.val);
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
                
            }
            ret.addFirst(curLevel);
        }
        return new ArrayList<>(ret);
    }

    public static void main(String[] args) {

    }
}
